package com.landz.android.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.landz.android.Model.Song;
import com.landz.android.Model.SongAdapter;
import com.landz.android.activity.Login;
import com.landz.android.R;
import com.landz.android.database.Database;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */
public class homeFragment extends Fragment {
    View view;
    Context context;
    public homeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageView imgAcc = view.findViewById(R.id.imgAcc);
        imgAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Login.class);
                startActivity(i);
            }
        });
        Database db = new Database(getActivity());
        ArrayList<Song> songs = db.getAllSong();
        RecyclerView rcv = view.findViewById(R.id.rcv_Song);
        SongAdapter adapter = new SongAdapter(getActivity(), songs);
        rcv.setAdapter(adapter);
        rcv.hasFixedSize();
        rcv.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        rcv.addItemDecoration(itemDecoration);
        return view;
    }



}