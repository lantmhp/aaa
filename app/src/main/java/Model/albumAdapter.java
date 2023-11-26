package Model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.landz.android.R;
import com.landz.android.activity.List_song_in_album;
import com.landz.android.databinding.ItemAlbumBinding;

import java.util.ArrayList;


public class albumAdapter extends RecyclerView.Adapter<albumAdapter.albumViewHolder>{
    Context context;
    ArrayList<album> albums;
    public albumAdapter(Context context, ArrayList<album> albums) {
        this.context = context;
        this.albums = albums;
    }

    @NonNull
    @Override
    public albumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent,false);
        return new albumViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull albumViewHolder holder, int position) {

        album a = albums.get(position);
        holder.binding.tvAlbum.setText(a.getAlbum_name());
        holder.binding.tvArtist.setText(a.getArtist_Name());
        Bitmap imageContent = BitmapFactory.decodeByteArray(a.getThumb(), 0, a.getThumb().length);
        holder.binding.imgItemAlbum.setImageBitmap(imageContent);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, List_song_in_album.class);
                intent.putExtra("aaa", a.getAlbum_id());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return albums.size();
    }

    public class albumViewHolder extends RecyclerView.ViewHolder{

        ItemAlbumBinding binding;
        public albumViewHolder(@NonNull View itemView) {
            super(itemView);

            binding = ItemAlbumBinding.bind(itemView);
        }
    }
}
