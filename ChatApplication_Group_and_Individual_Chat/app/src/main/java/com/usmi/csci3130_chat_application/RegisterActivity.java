package com.usmi.csci3130_chat_application;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.usmi.csci3130_chat_application.model.User;
import com.usmi.csci3130_chat_application.util.FirebaseConstants;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameET;
    private EditText passwordET;
    private Button registerBtn;
    private TextView existingEmployeeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        setListeners();
    }

    private void init() {
        usernameET = findViewById(R.id.usernameET);
        passwordET = findViewById(R.id.passwordET);
        registerBtn = findViewById(R.id.registerBtn);
        existingEmployeeTV = findViewById(R.id.existingEmployeeTV);
    }

    private void setListeners() {
        registerBtn.setOnClickListener(view -> registerUser());
        existingEmployeeTV.setOnClickListener(view -> moveToLoginScreen());
    }

    private void registerUser() {
        final String username = usernameET.getText().toString();
        final String password = passwordET.getText().toString();
//        creating the user
        final User newUser = new User(username, password);
//        pushing the user to the database
        FirebaseDatabase.getInstance(FirebaseConstants.FIREBASE_URL)
                .getReference()
                .child(FirebaseConstants.USERS_COLLECTION)
                .push()
                .setValue(newUser)
                .addOnSuccessListener(unused -> {
                    Toast.makeText(RegisterActivity.this,
                            getString(R.string.user_registered_successfully),
                            Toast.LENGTH_SHORT)
                            .show();
                    moveToLoginScreen();
                })
                .addOnFailureListener(e ->
                        Toast.makeText(RegisterActivity.this,
                                getString(R.string.user_registration_failed),
                                Toast.LENGTH_SHORT)
                                .show());
    }

    private void moveToLoginScreen() {
//        moving from register to login
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        finish();
    }
}