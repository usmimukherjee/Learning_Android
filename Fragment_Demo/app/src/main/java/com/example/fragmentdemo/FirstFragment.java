package com.example.fragmentdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import android.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

public class FirstFragment extends Fragment {


    View view;
    Button firstButton;

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_first, container, false);
        // get the reference of Button
        firstButton = (Button) view.findViewById(R.id.firstButton);
        // perform setOnClickListener on first Button
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        // display a message by using a Toast
                Snackbar.make( v,"First Fragment", Snackbar.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
