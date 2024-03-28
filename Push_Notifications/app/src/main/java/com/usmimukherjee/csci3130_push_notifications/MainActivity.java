package com.usmimukherjee.csci3130_push_notifications;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import com.google.auth.oauth2.GoogleCredentials;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {


    //path
    private static final String CREDENTIALS_FILE_PATH = "key.json";

    //provided by google - for sending the notification

    //new endpoint
    private static final String PUSH_NOTIFICATION_ENDPOINT ="https://fcm.googleapis.com/v1/projects/push-notification-3501d/messages:send";

    // for the send notification button
    private Button sendNotificationBtn;

    //provided by volley library to make a network request
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize components and set listeners
        init();
        setListeners();
    }

    private void getAccessToken(Context context, AccessTokenListener listener) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                InputStream serviceAccountStream = context.getAssets().open(CREDENTIALS_FILE_PATH);
                GoogleCredentials googleCredentials = GoogleCredentials
                        .fromStream(serviceAccountStream)
                        .createScoped(Collections.singletonList("https://www.googleapis.com/auth/firebase.messaging"));

                googleCredentials.refreshIfExpired(); // This will refresh the token if it's expired
                String token = googleCredentials.getAccessToken().getTokenValue();
                listener.onAccessTokenReceived(token);
            } catch (IOException e) {
                listener.onAccessTokenError(e);
            }
        });
        executorService.shutdown();
    }


    private void init() {

        sendNotificationBtn = findViewById(R.id.sendNotificationBtn);

        //adding multiple network request to a queue, FIFO based, running it separate threads, cannot run network request on the main thread in android
        //volley creates a separate thread for the network request
        requestQueue = Volley.newRequestQueue(this);

        //jobs is the topic name,subscribing to the jobs notification tray
        FirebaseMessaging.getInstance().subscribeToTopic("jobs");
    }

    private void setListeners() {
        sendNotificationBtn.setOnClickListener(view -> {
            // Attempt to get the access token
            getAccessToken(this, new AccessTokenListener() {
                @Override
                public void onAccessTokenReceived(String token) {
                    // When the token is received, send the notification
                    sendNotification(token);
                }

                @Override
                public void onAccessTokenError(Exception exception) {
                    // Handle the error appropriately
                    Toast.makeText(MainActivity.this, "Error getting access token: " + exception.getMessage(), Toast.LENGTH_LONG).show();
                    exception.printStackTrace();
                }
            });
        });
    }

    private void sendNotification(String token) {

        //the structure to be followed for sending the push notification
        /**
         * JSON Structure
         * {
         * ____"to": "/topics/jobs",
         * ____"notification": {
         * ________"title": "New Job Created",
         * ________"body": "A new job is created in your city."
         * ____},
         * ____"data": {
         * ________"jobId": "HF-128369",
         * ________"jobLocation": "Halifax",
         * ____}
         * }
         */

        //try catch block for JSON exception
        try {
            //the first json object - to
            JSONObject notificationJSONBody = new JSONObject();
            notificationJSONBody.put("title", "New Job Created");
            notificationJSONBody.put("body", "A new job is created in your city.");

            // Create the data JSON object
            JSONObject dataJSONBody = new JSONObject();
            dataJSONBody.put("jobLocation", "Halifax");
            dataJSONBody.put("job_id", "HF-128369");

            // Create the message JSON object and attach notification and data
            JSONObject messageJSONBody = new JSONObject();
            messageJSONBody.put("topic", "jobs");
            messageJSONBody.put("notification", notificationJSONBody);
            messageJSONBody.put("data", dataJSONBody);

            // Create the final push notification JSON object and attach the message
            JSONObject pushNotificationJSONBody = new JSONObject();
            pushNotificationJSONBody.put("message", messageJSONBody);
            //parameters sent in the request:
            //type of request - post- sending data to firebase
            //url - push notification endpoint
            //data - body of the notification
            //toast message
            //error listener
            Log.d("LOG", pushNotificationJSONBody.toString());
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,
                    PUSH_NOTIFICATION_ENDPOINT,
                    pushNotificationJSONBody,
                    //lamda syntax
                    response ->
                            Toast.makeText(MainActivity.this,
                                    "Notification Sent",
                                    Toast.LENGTH_SHORT).show(),
                    //method reference
                    Throwable::printStackTrace) {

                //adding the header to the endpoint
                //parameters used:
                //type of data
                //using the bearer token for authentication of the network request
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> headers = new HashMap<>();
                    headers.put("Content-Type", "application/json");
                    headers.put("Authorization", "Bearer " + token);
                    Log.d("headers", headers.toString());
                    return headers;
                }
            };
            //add the request to the queue
            requestQueue.add(request);
        } catch (JSONException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}