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

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.LibViewHolder>{

    private List<library> mdictionary;

    public LibraryAdapter(List<library> mdictionary) {
        this.mdictionary = mdictionary;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LibViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_lib, parent,false);
        return new LibViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull LibViewHolder holder, int position) {
        library library = mdictionary.get(position);
        if (library == null){
            return;
        }

        holder.imgLib.setImageResource(library.getImgLib());
        holder.tvNameLib.setText(library.getNameLib());
    }

    @Override
    public int getItemCount() {
        if (mdictionary != null){
            return mdictionary.size();
        }
        return 0;
    }

    public class LibViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgLib;
        private TextView tvNameLib;

        public LibViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLib = itemView.findViewById(R.id.img_lib);
            tvNameLib = itemView.findViewById(R.id.tv_name_lib);
        }
    }
}
