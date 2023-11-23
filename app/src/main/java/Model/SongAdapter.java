package Model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.landz.android.R;
import com.landz.android.activity.play_music;
import com.landz.android.databinding.ItemSongBinding;
import com.landz.android.detail;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder>{
    Context context;
    ArrayList<Song> songs;
    MediaPlayer mediaPlayer = new MediaPlayer();
    public void setSearchList(ArrayList<Song> songs) {

        this.songs = songs;
        notifyDataSetChanged();
    }

    public SongAdapter(Context context, ArrayList<Song> songs) {
        this.context = context;
        this.songs = songs;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song, parent,false);
        return new SongAdapter.SongViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song s = songs.get(position);
        holder.binding.tvTitle.setText(s.getSong_Title());
        holder.binding.tvArtistSong.setText(s.getSong_Artsit());
        holder.binding.tvDuration.setText(s.getDuration());
        Bitmap imageContent = BitmapFactory.decodeByteArray(s.getSong_Image(), 0, s.getSong_Image().length);
        holder.binding.imgSong.setImageBitmap(imageContent);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, play_music.class);
                intent.putExtra("id", s.getSong_Id());
                intent.putExtra("title", s.getSong_Title());
                intent.putExtra("duration", s.getDuration() );
                intent.putExtra("image", s.getSong_Image());
                intent.putExtra("data", s.getPath());
                if (mediaPlayer!=null){
                    mediaPlayer.stop();
                }
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder{
        ItemSongBinding binding;
        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemSongBinding.bind(itemView);
        }
    }
}
