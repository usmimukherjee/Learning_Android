package com.example.firebase_crud.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.firebase_crud.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button landing_page_button = findViewById(R.id.landing_page_button);

        //lambda representation
        //switching from landing page to the first page
        landing_page_button.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), ViewEmployeeActivity.class)));

    }
}