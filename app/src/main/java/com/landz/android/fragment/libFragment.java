package com.landz.android.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.landz.android.R;

import java.util.ArrayList;
import java.util.List;

import music.LibraryAdapter;
import music.library;

/**
 * A simple {@link Fragment} subclass.

 */
public class libFragment extends Fragment {

    private RecyclerView rcvCatLib;
    private ArrayList<library> arrayList;
    View view;

    public libFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_lib, container, false);
        rcvCatLib = view.findViewById(R.id.rcv_lib );
        
        return view;
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        rcvCatLib.setLayoutManager(new LinearLayoutManager(getContext()));
//        rcvCatLib.setHasFixedSize(true);
//        LibraryAdapter libraryAdapter = new LibraryAdapter(getContext(), arrayList);
//        rcvCatLib.setAdapter(libraryAdapter);
//        libraryAdapter.notifyDataSetChanged();
//        getListLib();
//    }
//
//    private List<library> getListLib() {
//        List<library> list = new ArrayList<>();
//        list.add(new library(R.drawable.img_heart, "Bài hát ưa thích", "ds,"));
//        list.add(new library(R.drawable.img_artist_1, "Sơn Tùng M-TP", "bf"));
//        list.add(new library(R.drawable.img_artist_2, "Low G", "sdj"));
//        list.add(new library(R.drawable.img_artist_3, "Taylor Swift", "jfdh"));
//        list.add(new library(R.drawable.img_heart, "Bài hát ưa thích", "sd"));
//        list.add(new library(R.drawable.img_heart, "Bài hát ưa thích", "mdmg"));
//
//        return list;
//    }
}