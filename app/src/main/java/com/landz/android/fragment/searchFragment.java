package com.landz.android.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.landz.android.activity.MainActivity;
import com.landz.android.R;
import com.landz.android.activity.search;

import java.util.ArrayList;
import java.util.List;

import music.CatSearch;
import music.CatSearchAdapter;
import music.LibraryAdapter;
import music.library;

/**
 * A simple {@link Fragment} subclass.
 */
public class searchFragment extends Fragment {
    MainActivity mainActivity;
    View view;
    Button btnSearch;

    RecyclerView rcvCatSearch;
    private List<CatSearch> searchList;
    private CatSearchAdapter searchAdapter;

    public searchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_search, container, false);
        mainActivity = (MainActivity) getActivity();
        btnSearch = view.findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), search.class);
                startActivity(i);

            }
        });

        searchList = getListSearch();
        rcvCatSearch = view.findViewById(R.id.rcv_CatSearch);
        rcvCatSearch.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        searchAdapter = new CatSearchAdapter(searchList);
        rcvCatSearch.setAdapter(searchAdapter);

        return view;

    }

    private List<CatSearch> getListSearch() {
        List<CatSearch> list = new ArrayList<>();
        list.add(new CatSearch(R.drawable.img_podcast));
        list.add(new CatSearch(R.drawable.img_podcast));
        list.add(new CatSearch(R.drawable.img_podcast));
        list.add(new CatSearch(R.drawable.img_podcast));
        list.add(new CatSearch(R.drawable.img_podcast));
        list.add(new CatSearch(R.drawable.img_podcast));
        list.add(new CatSearch(R.drawable.img_podcast));
        list.add(new CatSearch(R.drawable.img_podcast));
        list.add(new CatSearch(R.drawable.img_podcast));
        list.add(new CatSearch(R.drawable.img_podcast));
        list.add(new CatSearch(R.drawable.img_podcast));
        list.add(new CatSearch(R.drawable.img_podcast));

        return list;
    }
}