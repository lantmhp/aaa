package com.landz.android.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.landz.android.R;
import com.landz.android.fragment.homeFragment;
import com.landz.android.fragment.libFragment;
import com.landz.android.fragment.searchFragment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String DB_PATH_SUFFIX = "/databases/";
    String DATABASE_NAME="music.db";
    ViewPager2 fragment;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    BottomNavigationView bt_nav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        processCopy();
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
    private void processCopy() {
        //pri p vate app
        File dbFile = getDatabasePath(DATABASE_NAME);
        if (!dbFile.exists())
        {
            try{CopyDataBaseFromAsset();
                Toast.makeText(this, "Copying sucess from Assets folder", Toast.LENGTH_LONG).show();
            }
            catch (Exception e){
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }

    }
    private String getDatabasePath() {
        return getApplicationInfo().dataDir + DB_PATH_SUFFIX+ DATABASE_NAME;
    }

    public void CopyDataBaseFromAsset() {
        // TODO Auto-generated method stub
        try {
            InputStream myInput;
            myInput = getAssets().open(DATABASE_NAME);
            // Path to the just created empty db
            String outFileName = getDatabasePath();
            // if the path doesn't exist first, create it
            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if (!f.exists())
                f.mkdir();
            // Open the empty db as the output stream
            OutputStream myOutput = new FileOutputStream(outFileName);
            // transfer bytes from the inputfile to t@he outputfile
            // Truyền bytes dữ liệu từ input đến output
            int size = myInput.available();
            byte[] buffer = new byte[size];
            myInput.read(buffer);
            myOutput.write(buffer);
            // Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}