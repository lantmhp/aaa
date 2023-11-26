package com.landz.android.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.landz.android.R;

import java.util.ArrayList;
import java.util.List;

import Model.LibraryAdapter;
import Model.library;

public class search extends AppCompatActivity {
    private SearchView searchView;
    private RecyclerView recyclerView;
    private List<library> mLibraries;
    private LibraryAdapter libraryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);
        searchView = findViewById(R.id.searchview);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        recyclerView = findViewById(R.id.listSearchItem);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLibraries = new ArrayList<>();

        mLibraries.add(new library(R.drawable.img_heart, "Bài hát ưa thích", "ds,"));
        mLibraries.add(new library(R.drawable.img_artist_1, "Sơn Tùng M-TP", "bf"));
        mLibraries.add(new library(R.drawable.img_artist_2, "Low G", "sdj"));
        mLibraries.add(new library(R.drawable.img_artist_3, "Taylor Swift", "jfdh"));
        mLibraries.add(new library(R.drawable.img_heart, "Bài hát ưa thích", "sd"));
        mLibraries.add(new library(R.drawable.img_heart, "Bài hát ưa thích", "mdmg"));


    }

    private void filterList(String text) {
        List<library> fillteredList = new ArrayList<>();
        for (library library : mLibraries) {
            if (library.getNameLib().toLowerCase().contains(text.toLowerCase())) {
                fillteredList.add(library);
            }
        }
        if (fillteredList.isEmpty()) {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        } else {

        }
    }
}