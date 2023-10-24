package com.landz.android.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.landz.android.R;

import java.util.ArrayList;
import java.util.List;

import music.CatAlbumAdapter;
import music.CatSearch;
import music.CatSearchAdapter;
import music.album;
import music.albumAdapter;
import music.library;

/**
 * A simple {@link Fragment} subclass.
 */
public class homeFragment extends Fragment {
    View view;

    RecyclerView rcvCatAlbum;
    private List<album> albumList;
    private albumAdapter albumAdapter;

    public homeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        albumList = getListAlbum();
        rcvCatAlbum = view.findViewById(R.id.rcv_CatALbum);
        rcvCatAlbum.setLayoutManager(new LinearLayoutManager(getActivity()));
        albumAdapter = new albumAdapter(albumList);
        rcvCatAlbum.setAdapter(albumAdapter);
        return view;
    }

    private List<album> getListAlbum() {
        List<album> list = new ArrayList<>();
        list.add(new album(R.drawable.img_heart, "Bài hát ưa thích"));
        list.add(new album(R.drawable.img_artist_1, "Sơn Tùng M-TP"));
        list.add(new album(R.drawable.img_artist_2, "Low G"));
        list.add(new album(R.drawable.img_artist_3, "Taylor Swift"));
        list.add(new album(R.drawable.img_heart, "Bài hát ưa thích"));
        list.add(new album(R.drawable.img_heart, "Bài hát ưa thích"));

        return list;
    }

}