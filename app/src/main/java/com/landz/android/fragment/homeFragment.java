package com.landz.android.fragment;

import android.content.Context;
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

import music.CatAlbum;
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

    private List<CatAlbum> albumCatList;
    private RecyclerView rvcListAlbum;
    private CatAlbumAdapter CatAlbumAdapter;

    Context context;

    public homeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        albumCatList = getLisCatAlbum();
        rvcListAlbum = view.findViewById(R.id.rcv_CatALbum);

        rvcListAlbum.setLayoutManager(new LinearLayoutManager(getActivity()));
//        CatAlbumAdapter = new CatAlbumAdapter(this);
        rvcListAlbum.setAdapter(CatAlbumAdapter);
        return view;
    }

    private List<CatAlbum> getLisCatAlbum() {
        List<CatAlbum> listCat = new ArrayList<>();
        List<album> listAlbum1 = new ArrayList<>();
        listAlbum1.add(new album(R.drawable.img_album_1, "Album 1"));
        listAlbum1.add(new album(R.drawable.img_album_2, "Album 2"));
        listAlbum1.add(new album(R.drawable.img_album_3, "Album 3"));
        listAlbum1.add(new album(R.drawable.img_album_4, "Album 4"));

        List<album> listAlbum2 = new ArrayList<>();
        listAlbum2.add(new album(R.drawable.img_album_5, "Album 1"));
        listAlbum2.add(new album(R.drawable.img_album_6, "Album 2"));
        listAlbum2.add(new album(R.drawable.img_album_7, "Album 3"));
        listAlbum2.add(new album(R.drawable.img_album_8, "Album 4"));

        listCat.add(new CatAlbum("Dành cho bạn", listAlbum1));
        listCat.add(new CatAlbum("Radio phổ biến", listAlbum2));
        listCat.add(new CatAlbum("Lựa chọn của spotify", listAlbum1));
        listCat.add(new CatAlbum("Tuyển tập hàng đầu của bạn", listAlbum2));
        listCat.add(new CatAlbum("Đài phát gợi ý", listAlbum1));
        listCat.add(new CatAlbum("Hoài niệm", listAlbum2));
        return listCat;
    }

}