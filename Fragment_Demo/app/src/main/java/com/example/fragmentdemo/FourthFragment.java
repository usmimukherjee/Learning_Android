package com.example.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;


public class FourthFragment extends Fragment {

    View view;
    Button fourthButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fourth, container, false);
        // get the reference of Button
        fourthButton = (Button) view.findViewById(R.id.fourthButton);
        // perform setOnClickListener on second Button
        fourthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // display a message by using a Toast
                Snackbar.make(view, "Fourth Fragment", Snackbar.LENGTH_LONG).show();
            }
        });
        return view;
    }
}