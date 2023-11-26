package com.landz.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import com.landz.android.R;
import com.landz.android.database.Database;
import com.landz.android.databinding.ActivityPlayMusicBinding;

import java.io.IOException;
import java.util.ArrayList;

import Model.Song;

public class play_music extends AppCompatActivity {

    ActivityPlayMusicBinding binding;
    MediaPlayer mediaPlayer;
    private ArrayList<Song> songArrayList=new ArrayList<>();
    Song song;
    private Handler handler = new Handler();
    Database db = new Database(this);

    String path;
    private int currentIndex =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayMusicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String title = getIntent().getStringExtra("title");
        byte[] byteArray = getIntent().getByteArrayExtra("image");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        binding.imgPlay.setImageBitmap(bmp);
        binding.titleSong.setText(title);
        mediaPlayer = new MediaPlayer();
        binding.seekbarTime.setMax(100);
        prepareMediaPlayer();
        updateSeekbar();

        binding.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying())
                {
                    handler.removeCallbacks(updater);
                    mediaPlayer.pause();
                    binding.play.setImageResource(R.drawable.ic_pause_24);
                }else {
                    mediaPlayer.start();
                    binding.play.setImageResource(R.drawable.ic_play);
                    updateSeekbar();
                }
            }

        });
        songArrayList = db.getAllSong();
        int idsong = getIntent().getIntExtra("id", 0);
        currentIndex = idsong;

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                binding.next.performClick();
            }
        });
//        int audiosesssionId = mediaPlayer.getAudioSessionId();
//        if(audiosesssionId != -1){
//            vi
//        }
        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.play.setImageResource(R.drawable.ic_play);
                if (currentIndex < songArrayList.size())
                {
                    currentIndex ++;
                }
                else {
                    currentIndex = 1;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                mediaPlayer = new MediaPlayer();
                song = db.getsongbyId(currentIndex);
                binding.titleSong.setText(song.getSong_Title());
                Bitmap imageContent = BitmapFactory.decodeByteArray(song.getSong_Image(), 0, song.getSong_Image().length);
                binding.imgPlay.setImageBitmap(imageContent);
                path = song.getPath();
                try {

                    mediaPlayer.setDataSource(path);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    binding.end.setText(milliSecondsToTimer(mediaPlayer.getDuration()));
                    updateSeekbar();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        binding.prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.play.setImageResource(R.drawable.ic_play);
                if (currentIndex >1)
                {
                    currentIndex--;
                }
                else {
                    currentIndex = songArrayList.size();
                }
                song = db.getsongbyId(currentIndex);
                binding.titleSong.setText(song.getSong_Title());
                Bitmap imageContent = BitmapFactory.decodeByteArray(song.getSong_Image(), 0, song.getSong_Image().length);
                binding.imgPlay.setImageBitmap(imageContent);
                path = song.getPath();
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                mediaPlayer = new MediaPlayer();
                try {

                    mediaPlayer.setDataSource(path);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    binding.end.setText(milliSecondsToTimer(mediaPlayer.getDuration()));
                    updateSeekbar();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        binding.forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()+10000);
                    updateSeekbar();
                }

            }
        });
        binding.rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()-10000);
                    updateSeekbar();
                }

            }
        });
        binding.seekbarTime.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                SeekBar seekBar = (SeekBar) v;
                int playPosition = (mediaPlayer.getDuration()/100)*seekBar.getProgress();
                mediaPlayer.seekTo(playPosition);
                binding.start.setText(milliSecondsToTimer(mediaPlayer.getCurrentPosition()));
                return false;
            }
        });
        mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                binding.seekbarTime.setSecondaryProgress(percent);
            }
        });
    }
    private void prepareMediaPlayer(){
        String path = getIntent().getStringExtra("data");
        try {
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepare();
            binding.end.setText(milliSecondsToTimer(mediaPlayer.getDuration()));
            mediaPlayer.start();
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void restart(){
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.reset();
            }
        });
    }
    private Runnable updater = new Runnable() {
        @Override
        public void run() {
            updateSeekbar();
            long currentDuration = mediaPlayer.getCurrentPosition();
            binding.start.setText(milliSecondsToTimer(currentDuration));
            long updateDuration = (mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition());
            binding.end.setText(milliSecondsToTimer(updateDuration));
        }
    };

    private void updateSeekbar(){
        if (mediaPlayer.isPlaying()){
            binding.seekbarTime.setProgress((int) (((float) mediaPlayer.getCurrentPosition() / mediaPlayer.getDuration()) * 100));
            handler.postDelayed(updater, 1000);
        }
    }

    private String milliSecondsToTimer(long milliseconds){
        String timerString = "";
        String seconsString;

        int hours = (int)(milliseconds / (1000*60*60));
        int minutes = (int) (milliseconds % (1000*60*60))/(1000*60);
        int seconds = (int) ((milliseconds % (1000*60*60))%(1000*60)/1000);

        if (hours > 0){
            timerString = hours+":";
        }
        if (seconds<10){
            seconsString = "0" +seconds;
        }else
        {
            seconsString = "" + seconds;
        }
        timerString = timerString + minutes +":"+ seconsString;
        return timerString;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Giải phóng nguồn tài nguyên khi không sử dụng nữa
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}