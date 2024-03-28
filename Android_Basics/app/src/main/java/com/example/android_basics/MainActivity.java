package com.example.android_basics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// This is the main activity class that represents the entry point of the Android app.

public class MainActivity extends AppCompatActivity {

    @Override
    // This method is called when the activity is first created.
    protected void onCreate(Bundle savedInstanceState) {
        // Call the superclass's onCreate method to perform necessary setup before executing specific MainActivity logic.
        super.onCreate(savedInstanceState);

        // Sets the content view of the activity to the layout defined in activity_main.xml.
        setContentView(R.layout.activity_main);

    }
}