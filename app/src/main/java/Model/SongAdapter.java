package Model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.landz.android.R;
import com.landz.android.activity.play_music;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder>{
    Context context;
    ArrayList<Song> songs;

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
        holder.tvTitle.setText(s.getSong_Title());
        holder.tvAristSong.setText(s.getSong_Artsit());
        Bitmap imageContent = BitmapFactory.decodeByteArray(s.getSong_Image(), 0, s.getSong_Image().length);
        holder.img.setImageBitmap(imageContent);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, play_music.class);
//                intent.putExtra("doc", s);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder{
        public TextView tvTitle;
        public TextView tvAristSong;
        public ImageView img;
        public View view;
        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            this.tvTitle = itemView.findViewById(R.id.tv_title);
            this.tvAristSong = itemView.findViewById(R.id.tv_artist_song);
            this.img = itemView.findViewById(R.id.img_song);
        }
    }
}
