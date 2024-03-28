package com.usmi.csci3130_chat_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.usmi.csci3130_chat_application.adapter.ChatAdapter;
import com.usmi.csci3130_chat_application.model.Chat;
import com.usmi.csci3130_chat_application.session.UserSession;
import com.usmi.csci3130_chat_application.util.FirebaseConstants;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ChatActivity extends AppCompatActivity {

    public static final String CHAT_COLLECTION = "CHAT_COLLECTION";
    private RecyclerView chatRecyclerView;
    private ChatAdapter chatAdapter;
    private EditText chatMessageET;
    private Button chatSendBtn;
    private String chatCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        init();
        getChatCollection();
        setListeners();
        getChatMessages();
    }

    private void init() {
        chatRecyclerView = findViewById(R.id.chatRecyclerView);
        chatMessageET = findViewById(R.id.chatMessageET);
        chatSendBtn = findViewById(R.id.chatSendBtn);
    }

    private void getChatCollection() {
        chatCollection = getIntent().getExtras().getString(CHAT_COLLECTION);
    }

    private void setListeners() {
        chatSendBtn.setOnClickListener(view -> sendMessage());
    }

    private void getChatMessages() {
//        getting the chat messages
        final FirebaseRecyclerOptions<Chat> options = new FirebaseRecyclerOptions.Builder<Chat>()
                .setQuery(FirebaseDatabase.getInstance(FirebaseConstants.FIREBASE_URL)
                        .getReference()
                        .child(chatCollection), Chat.class)
                .build();
//        getting chat adapter object and then bind the recycler view to the adapter
        chatAdapter = new ChatAdapter(options);
        chatRecyclerView.setAdapter(chatAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //inflating the logout button on the menu
        getMenuInflater().inflate(R.menu.menu_chat,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        //creating an intent to move to login page when the logout button is clicked
        if(item.getItemId() == R.id.logoutItem){
            UserSession.getInstance().setUser(null);
            startActivity(new Intent(ChatActivity.this, LoginActivity.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    private void sendMessage() {
        final String chatMessage = chatMessageET.getText().toString();
        final Chat chatMessageObj = new Chat(UserSession.getInstance().getUser().getUsername(), chatMessage);
        //storing the message and the username in the chat collection in database
        FirebaseDatabase.getInstance(FirebaseConstants.FIREBASE_URL)
                .getReference()
                .child(chatCollection)
                .push()
                .setValue(chatMessageObj)
                .addOnSuccessListener(unused -> chatMessageET.setText(""))
                .addOnFailureListener(e ->
                        Toast.makeText(ChatActivity.this,
                                getString(R.string.failed_to_send_message),
                                Toast.LENGTH_SHORT)
                                .show());
    }

    @Override
    protected void onStart() {
        super.onStart();
        chatAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        chatAdapter.stopListening();
    }
}