package com.usmi.csci3130_chat_application;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.usmi.csci3130_chat_application.model.User;
import com.usmi.csci3130_chat_application.session.UserSession;
import com.usmi.csci3130_chat_application.util.FirebaseConstants;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

//working with the login activity
public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getName();
    private EditText usernameET;
    private EditText passwordET;
    private Button loginBtn;
    private TextView newEmployeeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        setListeners();
    }

    private void init() {
        usernameET = findViewById(R.id.usernameET);
        passwordET = findViewById(R.id.passwordET);
        loginBtn = findViewById(R.id.loginBtn);
        newEmployeeTV = findViewById(R.id.newEmployeeTV);
    }

    private void setListeners() {
        loginBtn.setOnClickListener(view -> loginUser());
        newEmployeeTV.setOnClickListener(view -> moveToRegisterScreen());
    }

    private void loginUser() {

        final String username = usernameET.getText().toString();
        final String password = passwordET.getText().toString();

        //    searching for the username that is already present in the firebase database
        final Query usernameQuery = FirebaseDatabase.getInstance(FirebaseConstants.FIREBASE_URL)
                .getReference()
                .child(FirebaseConstants.USERS_COLLECTION)
                .orderByChild("username")
                .equalTo(username);

        usernameQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

//              if the user exists i.e registered
                if (snapshot.exists() && snapshot.getChildrenCount() > 0) {

//                  checking if the password entered is the same password that is registered by the user
                    final User user = snapshot.getChildren().iterator().next().getValue(User.class);

                    if (user != null && user.getPassword().equals(password)) {
                        Toast.makeText(LoginActivity.this,
                                "Login successful",
                                Toast.LENGTH_SHORT)
                                .show();

                        // Storing the user in the session - to get the user during the session
                        UserSession.getInstance().setUser(user);

//                      move the activity from login to select
                        Intent chatActivityIntent = new Intent(LoginActivity.this, ChatActivity.class);
                        chatActivityIntent.putExtra(ChatActivity.CHAT_COLLECTION, FirebaseConstants.CHAT_COLLECTION);
                        startActivity(chatActivityIntent);
                        finish();

                    } else {
//                        for incorrect username and password
                        Toast.makeText(LoginActivity.this,
                                "Invalid login credentials",
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
//                displaying a log message whenever anything goes wrong
                Log.e(TAG, error.getMessage());
            }
        });
    }

    private void moveToRegisterScreen() {
//        this will start the activity and move from login to register activity
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
//        to stop the previous activity which is the login activity
        finish();
    }
}