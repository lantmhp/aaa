package music;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.landz.android.R;

import java.util.List;

public class albumAdapter extends RecyclerView.Adapter<albumAdapter.albumViewHolder>{

    private List<album> mAlbum;

    public void setData(List<album> list){
        this.mAlbum = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public albumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album, parent,false);
        return new albumViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull albumViewHolder holder, int position) {

        album album = mAlbum.get(position);
        if (album == null){
            return;
        }

        holder.imgAlbum.setImageResource(album.getResourceId());
        holder.tvAlbum.setText(album.getNameAlbum());

    }

    @Override
    public int getItemCount() {
        if (mAlbum != null){
            return mAlbum.size();
        }
        return 0;
    }

    public class albumViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgAlbum;
        private TextView tvAlbum;

        public albumViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAlbum = itemView.findViewById(R.id.img_album);
            tvAlbum = itemView.findViewById(R.id.tv_album);
        }
    }
}
