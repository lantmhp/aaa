package com.landz.android.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.landz.android.activity.MainActivity;
import com.landz.android.R;
import com.landz.android.activity.search;

/**
 * A simple {@link Fragment} subclass.
 */
public class searchFragment extends Fragment {
    MainActivity mainActivity;
    View view;
    Button btnSearch;

    public searchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_search, container, false);
        mainActivity = (MainActivity)getActivity();
        btnSearch = view.findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), search.class);
                startActivity(i);

            }
        });
        return view;

    }
}