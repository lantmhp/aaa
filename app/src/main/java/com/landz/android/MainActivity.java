package com.landz.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import music.album;
import music.CatAlbum;
import music.CatAlbumAdapter;
public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    private RecyclerView rvcListAlbum;
    private CatAlbumAdapter CatAlbumAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvcListAlbum = findViewById(R.id.rcv_CatALbum );
        CatAlbumAdapter = new CatAlbumAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rvcListAlbum.setLayoutManager(linearLayoutManager);

        CatAlbumAdapter.setData(getLisCatAlbum());
        rvcListAlbum.setAdapter(CatAlbumAdapter);
    }


    private List<CatAlbum> getLisCatAlbum() {
        List<CatAlbum> listCat =new ArrayList<>();
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

    @Override
    public void onClick(View view) {

    }
}