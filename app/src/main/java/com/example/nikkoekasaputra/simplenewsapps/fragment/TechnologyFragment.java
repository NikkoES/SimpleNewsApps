package com.example.nikkoekasaputra.simplenewsapps.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nikkoekasaputra.simplenewsapps.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TechnologyFragment extends Fragment {


    public TechnologyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_technology, container, false);
    }

}