package com.example.examenapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment3 extends Fragment {

    Button button;

    public Fragment3() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        button = view.findViewById(R.id.btnAcividad);
        button.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), activity2.class);
            startActivity(intent);
        });
        return view;
    }
}