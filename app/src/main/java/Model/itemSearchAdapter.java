package Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import com.landz.android.R;

import java.util.ArrayList;

public class itemSearchAdapter extends RecyclerView.Adapter<itemSearchAdapter.ItemViewHolder> {

    ArrayList<itemSearch> list;

    public itemSearchAdapter(ArrayList<itemSearch> list, Context context) {
        this.list = list;
        this.context = context;
        layoutInflater=LayoutInflater.from(context);
    }

    LayoutInflater layoutInflater;

    Context context;

    public itemSearchAdapter(ArrayList<itemSearch> searchList, SearchView.OnQueryTextListener onQueryTextListener) {
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_search, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        itemSearch itSearch = list.get(position);

        holder.imgItem.setImageResource(itSearch.getImgSearch());
        holder.nameItem.setText(itSearch.getNameItem());
        holder.nameCateItem.setText(itSearch.getNameCateItem());
    }


    @Override
    public int getItemCount() {

        return list.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgItem;
        private TextView nameItem;
        private TextView nameCateItem;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.img_search);
            nameItem = itemView.findViewById(R.id.tv_name_search);
//            nameCateItem = itemView.findViewById(R.id.tv_name_cate_search);
        }
    }
}