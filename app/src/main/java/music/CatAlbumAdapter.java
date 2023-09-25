package music;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.landz.android.R;

import java.util.List;

public class CatAlbumAdapter extends RecyclerView.Adapter<CatAlbumAdapter.CatAlbumViewHolder>{

    private Context mContext;
    private List<CatAlbum> mlistCatAlbum;
    public CatAlbumAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void  setData(List<CatAlbum> list){
        this.mlistCatAlbum = list;

    }

    @NonNull
    @Override
    public CatAlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_album, parent, false);
        return new CatAlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatAlbumViewHolder holder, int position) {
        CatAlbum catAlbum = mlistCatAlbum.get(position);
        if(catAlbum == null){
            return;
        }

        holder.tvNameCatAlbum.setText(catAlbum.getNameList());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
        holder.rcvAlbum.setLayoutManager(linearLayoutManager);


        albumAdapter bookAdapter = new albumAdapter();
        bookAdapter.setData(catAlbum.getAlbums());
        holder.rcvAlbum.setAdapter(bookAdapter);
    }

    @Override
    public int getItemCount() {
        if (mlistCatAlbum != null){
            return mlistCatAlbum.size();

        }
        return 0;
    }

    public class CatAlbumViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNameCatAlbum;
        private RecyclerView rcvAlbum;

        public CatAlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameCatAlbum = itemView.findViewById(R.id.tv_cat_album);
            rcvAlbum = itemView.findViewById(R.id.rcv_album);
        }
    }
}
