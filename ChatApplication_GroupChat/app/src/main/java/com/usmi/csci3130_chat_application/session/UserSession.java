package com.usmi.csci3130_chat_application.session;

import com.usmi.csci3130_chat_application.model.User;

//uses a singleton design pattern. It will have one object throughout the application
//whenever a user logs in - the user details is stored in user
// whenever the application is closed, the user is not lost
public class UserSession {

    private static UserSession instance;
    private User user;

    private UserSession() {
    }

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}