package com.landz.android;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import music.LibraryAdapter;

public class library extends AppCompatActivity {
    private RecyclerView rcvCatLib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        rcvCatLib = findViewById(R.id.rcv_lib );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCatLib.setLayoutManager(linearLayoutManager);

        LibraryAdapter libraryAdapter = new LibraryAdapter(getListLib());
        rcvCatLib.setAdapter(libraryAdapter);
    }

    private List<music.library> getListLib() {
        List<music.library> list = new ArrayList<>();
        list.add(new music.library(R.drawable.img_heart, "Bài hát ưa thích"));
        list.add(new music.library(R.drawable.img_artist_1, "Sơn Tùng M-TP"));
        list.add(new music.library(R.drawable.img_artist_2, "Low G"));
        list.add(new music.library(R.drawable.img_artist_3, "Taylor Swift"));
        list.add(new music.library(R.drawable.img_heart, "Bài hát ưa thích"));
        list.add(new music.library(R.drawable.img_heart, "Bài hát ưa thích"));

        return list;
    }


}