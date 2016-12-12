package com.example.panda.munger.Event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.panda.munger.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EventSingleActivity extends AppCompatActivity {

    private String mPost_key = null;

    private DatabaseReference mDatabase;
    private static final String FIREBASE_URL = "https://chat-8ff4f.firebaseio.com/Event";

    private TextView textViewSingleTitle;
    private TextView textViewSingleLocation;
    private TextView textViewSingleDateTime;
    private TextView textViewSingleDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_single);

        mDatabase = FirebaseDatabase.getInstance().getReferenceFromUrl(FIREBASE_URL);

        mPost_key = getIntent().getExtras().getString("event_id");

        textViewSingleTitle = (TextView) findViewById(R.id.textViewSingleTitle);
        textViewSingleLocation = (TextView) findViewById(R.id.textViewSingleLocation);
        textViewSingleDateTime = (TextView) findViewById(R.id.textViewSingleDateTime);
        textViewSingleDescription = (TextView) findViewById(R.id.textViewSingleDescription);

        //Toast.makeText(EventSingleActivity.this, post_key, Toast.LENGTH_SHORT).show();

        mDatabase.child(mPost_key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String event_title = (String) dataSnapshot.child("title").getValue();
                String event_location = (String) dataSnapshot.child("location").getValue();
                String event_datetime = (String) dataSnapshot.child("datetime").getValue();
                String event_description = (String) dataSnapshot.child("description").getValue();

                textViewSingleTitle.setText(event_title);
                textViewSingleLocation.setText(event_location);
                textViewSingleDateTime.setText(event_datetime);
                textViewSingleDescription.setText(event_description);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
