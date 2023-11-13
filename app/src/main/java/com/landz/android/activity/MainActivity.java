package com.landz.android.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;


import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import android.widget.Button;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.landz.android.R;
import com.landz.android.fragment.ViewPager2Adapter;
import com.landz.android.fragment.homeFragment;
import com.landz.android.fragment.libFragment;
import com.landz.android.fragment.searchFragment;

import java.util.ArrayList;

import music.CatAlbumAdapter;

public class MainActivity extends AppCompatActivity {


    ViewPager2 fragment;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    BottomNavigationView bt_nav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//        DatabaseReference databaseReference = firebaseDatabase.getReferenceFromUrl("https://musicapp-fa97c-default-rtdb.firebaseio.com/");
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                DataSnapshot snapshot1 = snapshot.child("name");
//                String value = snapshot1.getValue(String.class);
//                Log.d("aaa", value);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(MainActivity.this, "Fail to get data", Toast.LENGTH_SHORT).show();
//            }
//        });

        fragment = findViewById(R.id.fragment);
        bt_nav = findViewById(R.id.bt_nav);

        fragmentArrayList.add(new homeFragment());
        fragmentArrayList.add(new searchFragment());
        fragmentArrayList.add(new libFragment());


        ViewPager2Adapter adapter = new ViewPager2Adapter(this, fragmentArrayList);
        fragment.setAdapter(adapter);

        fragment.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bt_nav.setSelectedItemId(R.id.homeFragment);
                        break;
                    case 1:
                        bt_nav.setSelectedItemId(R.id.searchFragment);
                        break;
                    case 2:
                        bt_nav.setSelectedItemId(R.id.libFragment);
                        break;
                }
                super.onPageSelected(position);
            }
        });

        bt_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.Home) {
                    fragment.setCurrentItem(0);
                } else {
                    if (item.getItemId() == R.id.Search) {
                        fragment.setCurrentItem(1);
                    } else fragment.setCurrentItem(2);
                }

                return true;
            }
        });

    }

}