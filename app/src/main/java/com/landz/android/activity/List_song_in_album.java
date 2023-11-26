package com.landz.android.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.landz.android.R;
import com.landz.android.database.Database;
import com.landz.android.databinding.ActivityListSongInAlbumBinding;

import java.util.ArrayList;

import Model.Song;
import Model.SongAdapter;

public class List_song_in_album extends AppCompatActivity {
    ArrayList<Song> songs;
    SongAdapter adapter;
    ActivityListSongInAlbumBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListSongInAlbumBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Database db = new Database(this);
        Intent intent = getIntent();
        int album_id = intent.getIntExtra("aaa", 0);
        songs = db.getSongsForAlbum(album_id);
        RecyclerView rcv = findViewById(R.id.rcv_Song_in_Album);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcv.addItemDecoration(itemDecoration);
        adapter = new SongAdapter(this, songs);
        rcv.setAdapter(adapter);
        rcv.hasFixedSize();
        rcv.setLayoutManager(new LinearLayoutManager(this));

    }

}