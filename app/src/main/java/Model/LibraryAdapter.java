package Model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.landz.android.R;

import java.util.List;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.LibViewHolder> {


    private List<library> mLibraries;

    public LibraryAdapter(List<library> mLibraries) {
        this.mLibraries = mLibraries;
    }

    @NonNull
    @Override
    public LibViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_lib, parent, false);
        return new LibViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull LibViewHolder holder, int position) {
        library library = mLibraries.get(position);

        holder.imgLib.setImageResource(library.getImgLib());
        holder.tvNameLib.setText(library.getNameLib());
        holder.tvNameCat.setText(library.getNameCat());
    }

    @Override
    public int getItemCount() {
        return mLibraries.size();
    }

    public static class LibViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgLib;
        private TextView tvNameLib;

        private TextView tvNameCat;

        public LibViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLib = itemView.findViewById(R.id.img_lib);
            tvNameLib = itemView.findViewById(R.id.tv_name_lib);
            tvNameCat = itemView.findViewById(R.id.tv_name_cate);
        }
    }
}