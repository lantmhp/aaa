package com.landz.android.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.landz.android.R;
import com.landz.android.database.Database;

import java.util.ArrayList;
import java.util.List;

import Model.Song;
import Model.SongAdapter;
import Model.itemSearch;
import Model.itemSearchAdapter;

public class search extends AppCompatActivity {


    SearchView searchView;
    ArrayList<Song> songArrayList;
    SongAdapter adapter;
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
                searchList(newText);
                return true;
            }
        });
        Database db = new Database(this);
        songArrayList = db.getAllSong();
        RecyclerView rcv = findViewById(R.id.rcvSearchItem);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcv.addItemDecoration(itemDecoration);
        adapter = new SongAdapter(this, songArrayList);
        rcv.setAdapter(adapter);
        rcv.hasFixedSize();
        rcv.setLayoutManager(new LinearLayoutManager(this));


    }

    private void searchList(String Text) {
        ArrayList<Song> songsSearchList = new ArrayList<>();
        for (Song song : songArrayList){
            if (song.getSong_Title().toLowerCase().contains(Text.toLowerCase())) {
                songsSearchList.add(song);
            }
        }
        if (songsSearchList.isEmpty()){
            Toast.makeText(this,"Not found", Toast.LENGTH_SHORT).show();
        }
        else {
            adapter.setSearchList(songsSearchList);
        }
    }


}