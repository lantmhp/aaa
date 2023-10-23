package com.landz.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;

import com.landz.android.R;

import java.util.ArrayList;

public class play_music extends AppCompatActivity {

    ImageView play,prev,next,imageView;
    TextView songTile;
    SeekBar mSeekBarTime, mSeekBarVol;
    static MediaPlayer mediaPlayer;
    private Runnable runnable;
    private MediaController mediaController;
    private AudioManager manager;
    int currentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        play = findViewById(R.id.play);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        mSeekBarTime = findViewById(R.id.seekbarTime);
        mSeekBarVol = findViewById(R.id.seekbarVol);

        ArrayList<Integer> songs = new ArrayList<>();
        songs.add(0,R.raw.sontung1);
        songs.add(1,R.raw.coChacYeuLaDay);
        songs.add(2,R.raw.fashionTanGai);
        songs.add(3,R.raw.hayTraoChoAnh);
        songs.add(4,R.raw.luonYeuDoi);
        songs.add(5,R.raw.noiNayCoAnh);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer!=null &&mediaPlayer.isPlaying())
                {
                    mediaPlayer.pause();
                }
                else
                {
                    mediaPlayer.start();
                    play.setImageResource(R.drawable.ic_pause_24);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer!=null)
                {
                    play.setImageResource(R.drawable.ic_pause_24);
                }
                if (currentIndex <songs.size()-1)
                {
                    currentIndex++;
                }
                else currentIndex = 0;
                if (mediaPlayer.isPlaying())
                {
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mediaPlayer.start();
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer!=null){
                    play.setImageResource(R.drawable.ic_pause_24);
                }
                if (currentIndex >0)
                {
                    currentIndex--;
                }
                else currentIndex = songs.size() -1;
                if (mediaPlayer.isPlaying())
                {
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mediaPlayer.start();
            }
        });
    }
    private void SongNames() {
        if (currentIndex == 0)
        {
            songTile.setText("Chung ta khong thuoc ve nhau - Son Tung MTP");
            imageView.setImageResource((R.drawable.chungtakothuocvenhau));
        }
        if (currentIndex == 1)
        {
            songTile.setText("Co chac yeu la day - Son Tung MTP");
            imageView.setImageResource((R.drawable.chungtakothuocvenhau));
        }
        if (currentIndex == 2)
        {
            songTile.setText("Fashion tan gai - LowG");
            imageView.setImageResource((R.drawable.chungtakothuocvenhau));
        }
        if (currentIndex == 3)
        {
            songTile.setText("Hay trao cho anh - Son Tung MTP");
            imageView.setImageResource((R.drawable.chungtakothuocvenhau));
        }
        if (currentIndex == 4)
        {
            songTile.setText("Luon yeu doi - LowG");
            imageView.setImageResource((R.drawable.chungtakothuocvenhau));
        }
        if (currentIndex == 5)
        {
            songTile.setText("Noi nay co anh - Son Tung MTP");
            imageView.setImageResource((R.drawable.chungtakothuocvenhau));
        }
    }
}