package com.usmimukherjee.csci3130_push_notifications;

public interface AccessTokenListener {
    void onAccessTokenReceived(String token);
    void onAccessTokenError(Exception exception);
}