package com.example.firebase_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the Firebase database instance with the specified URL
        FirebaseDatabase db = FirebaseDatabase.getInstance("https://fir-demo-1a8f4-default-rtdb.firebaseio.com/");

        // Get a reference to the "message" node in the database
        DatabaseReference dbref = db.getReference("message");

        // Set the value of the "message" node to "Hello How are you"
        dbref.setValue("Hello How are you");

        // Add a ValueEventListener to listen for changes in the data at the "message" node
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Retrieve the value from the DataSnapshot
                String value = snapshot.getValue(String.class);

                // Find the TextView with the specified ID
                TextView tv = findViewById(R.id.textView1);

                // Set the text of the TextView to the retrieved value
                tv.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle any errors that occur during data retrieval
                // (Note: This block is currently empty, and you might want to add error handling logic here if needed)
            }
        });
    }
}