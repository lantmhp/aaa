package com.landz.android.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.landz.android.R;
import com.landz.android.activity.MainActivity;
import com.landz.android.activity.search;
import com.landz.android.database.Database;
import com.landz.android.databinding.FragmentSearchBinding;

import java.util.ArrayList;

import Model.album;
import Model.albumAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class searchFragment extends Fragment {
    MainActivity mainActivity;
    View view;
    Button btnSearch;
    FragmentSearchBinding binding;

    public searchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_search, container, false);
        mainActivity = (MainActivity) getActivity();
        btnSearch = view.findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), search.class);
                startActivity(i);

            }
        });
        Database db = new Database(getActivity());
        ArrayList<album> albums = db.getAllAlbum();
        RecyclerView rcv = view.findViewById(R.id.rcv_album);
        albumAdapter adapter = new albumAdapter(getActivity(),albums);
        rcv.setAdapter(adapter);
        rcv.hasFixedSize();
        rcv.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return view;

    }
}