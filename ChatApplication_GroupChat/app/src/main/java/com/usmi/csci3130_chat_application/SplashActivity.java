package com.usmi.csci3130_chat_application;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.usmi.csci3130_chat_application.session.UserSession;

//the different activities that need to be displayed
//dependend on the user session
//reason for having it -> for performing tasks before hand
//doesn't have a view -> can add a view

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //        incase the user is logged in, then displaying the CHAT activity
        if (UserSession.getInstance() != null && UserSession.getInstance().getUser() != null) {
            startActivity(new Intent(SplashActivity.this, ChatActivity.class));
        }

        //        incase the user is not logged in, then displaying the LOGIN activity
        else {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        }

        finish();
    }
}
