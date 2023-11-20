package com.landz.android.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.landz.android.R;

import java.util.ArrayList;
import java.util.List;

import Model.LibraryAdapter;
import Model.library;

/**
 * A simple {@link Fragment} subclass.
 */
public class libFragment extends Fragment {

    RecyclerView rcvCatLib;
    private List<library> libraryList;
    private LibraryAdapter libraryAdapter;

    public libFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lib, container, false);

        libraryList = getListLib();
        rcvCatLib = view.findViewById(R.id.rcv_lib);
        rcvCatLib.setLayoutManager(new LinearLayoutManager(getActivity()));
        libraryAdapter = new LibraryAdapter(libraryList);
        rcvCatLib.setAdapter(libraryAdapter);

        return view;
    }


    private List<library> getListLib() {
        List<library> list = new ArrayList<>();
        list.add(new library(R.drawable.img_heart, "Bài hát ưa thích", "Album"));
        list.add(new library(R.drawable.img_artist_1, "Sơn Tùng M-TP", "Ca sĩ"));
        list.add(new library(R.drawable.img_artist_2, "Low G", "Ca sĩ"));
        list.add(new library(R.drawable.img_artist_3, "Taylor Swift", "Ca sĩ"));
        list.add(new library(R.drawable.img_heart, "Bài hát ưa thích", "Album"));
        list.add(new library(R.drawable.img_heart, "Bài hát ưa thích", "Album"));

        return list;
    }
}