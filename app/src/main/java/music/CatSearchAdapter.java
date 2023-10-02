package music;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.landz.android.R;

import java.util.List;

public class CatSearchAdapter extends RecyclerView.Adapter<CatSearchAdapter.CatSearchViewHolder>{

    private List<CatSearch> mListCatSearches;

    public CatSearchAdapter(List<CatSearch> mListCatSearches) {
        this.mListCatSearches = mListCatSearches;
    }

    @NonNull
    @Override
    public CatSearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_view, parent, false);
        return new CatSearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatSearchViewHolder holder, int position) {
        CatSearch CatSearch = mListCatSearches.get(position);
        if(CatSearch == null){
            return;
        }

        holder.imgSearch.setImageResource(CatSearch.getImgSearch());
    }

    @Override
    public int getItemCount() {
        if(mListCatSearches != null){
            return mListCatSearches.size();
        }
        return 0;
    }

    public class CatSearchViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgSearch;
        public CatSearchViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSearch = itemView.findViewById(R.id.img_item_searchView);
        }
    }
}
