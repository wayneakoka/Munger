package com.example.panda.munger.Chat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.panda.munger.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static com.example.panda.munger.Facebook.PrefUtils.getCurrentUser;


public class ChatActivity extends AppCompatActivity {
    private static final String TAG = "ChatActivity";
    private static final int RC_PHOTO_PICKER = 1;
    private EditText chat_inbox;
    private ChatMessageAdapter adapter;
    private Button chat_send;
    private FirebaseApp app;
    private FirebaseDatabase database;
    private FirebaseAuth auth;
    private FirebaseStorage storage;
    private DatabaseReference databaseRef;
    private StorageReference storageRef;
    private String username;
    private RecyclerView messagesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        username = getCurrentUser(getApplicationContext()).username;
        setTitle("Chatting as " + username);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        chat_send = (Button) findViewById(R.id.chat_send);
        chat_inbox  = (EditText) findViewById(R.id.chat_inbox);
        messagesList = (RecyclerView) findViewById(R.id.messagesList);
        messagesList.setHasFixedSize(false);
        messagesList.setLayoutManager(layoutManager);

        chat_send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ChatMessage chat = new ChatMessage(chat_inbox.getText().toString(), username);
                // Push the chat message to the database
                databaseRef.push().setValue(chat);
                chat_inbox.setText("");
            }
        });
        adapter = new ChatMessageAdapter(this);
        messagesList.setAdapter(adapter);
        // When record added, list will scroll to bottom
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            public void onItemRangeInserted(int positionStart, int itemCount) {
                messagesList.smoothScrollToPosition(adapter.getItemCount());
            }
        });

        // Get the Firebase app and all primitives we'll use
        app = FirebaseApp.getInstance();
        database = FirebaseDatabase.getInstance(app);
        auth = FirebaseAuth.getInstance(app);
        storage = FirebaseStorage.getInstance(app);

        // Get a reference to our chat "room" in the database
        databaseRef = database.getReference("chat");

        // Listen for when child nodes get added to the collection
        databaseRef.addChildEventListener(new ChildEventListener() {
            public void onChildAdded(DataSnapshot snapshot, String s) {
                // Get the chat message from the snapshot and add it to the UI
                ChatMessage chat = snapshot.getValue(ChatMessage.class);
                adapter.addMessage(chat);
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }
}

