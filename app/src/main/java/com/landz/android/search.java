package com.landz.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import music.CatSearch;
import music.CatSearchAdapter;

public class search extends AppCompatActivity {
    private Button btnHome;

    private RecyclerView rcvCatSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        rcvCatSearch = findViewById(R.id.rcv_CatSearch);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rcvCatSearch.setLayoutManager(gridLayoutManager);

        CatSearchAdapter adapter = new CatSearchAdapter(getListCatSearch());
        rcvCatSearch.setAdapter(adapter);
        btnHome = findViewById(R.id.btn_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomeView();
            }
        });
    }

    private List<CatSearch> getListCatSearch() {
        List<CatSearch> list = new ArrayList<>();
        list.add(new CatSearch((R.drawable.img_podcast)));
        list.add(new CatSearch((R.drawable.img_podcast)));
        list.add(new CatSearch((R.drawable.img_podcast)));
        list.add(new CatSearch((R.drawable.img_podcast)));
        list.add(new CatSearch((R.drawable.img_podcast)));
        list.add(new CatSearch((R.drawable.img_podcast)));
        list.add(new CatSearch((R.drawable.img_podcast)));
        list.add(new CatSearch((R.drawable.img_podcast)));
        list.add(new CatSearch((R.drawable.img_podcast)));
        list.add(new CatSearch((R.drawable.img_podcast)));
        list.add(new CatSearch((R.drawable.img_podcast)));
        list.add(new CatSearch((R.drawable.img_podcast)));
        list.add(new CatSearch((R.drawable.img_podcast)));
        list.add(new CatSearch((R.drawable.img_podcast)));

        return list;
    }

    public void openHomeView(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}