package com.myapp.tdd_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent intent = getIntent();
        String value = intent.getStringExtra("key");

        TextView tv = (TextView)findViewById(R.id.welcome);
//        tv.setText(value.toString());
        tv.setText("Welcome");

    }
}