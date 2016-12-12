package com.example.panda.munger.Event;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.panda.munger.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostActivity extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextLocation;
    private EditText editTextDateTime;
    private EditText editTextDescription;
    private Button buttonSubmit;

    //private StorageReference mStorage; -video part 4

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        //mStorage = FirebaseStorage.getInstance().getReference();

        mDatabase = FirebaseDatabase.getInstance().getReference("Event");

        editTextTitle = (EditText) findViewById(R.id.editTextTitle);
        editTextLocation = (EditText) findViewById(R.id.editTextLocation);
        editTextDateTime = (EditText) findViewById(R.id.editTextDateTime);
        editTextDescription = (EditText) findViewById(R.id.editTextDescription);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startPosting();
            }
        });


    }

    private void startPosting() {

        String title_val = editTextTitle.getText().toString().trim();
        String location_val = editTextLocation.getText().toString().trim();
        String datetime_val = editTextDateTime.getText().toString().trim();
        String description_val = editTextDescription.getText().toString().trim();

        if (!TextUtils.isEmpty(title_val) && !TextUtils.isEmpty(location_val) &&
                !TextUtils.isEmpty(datetime_val) && !TextUtils.isEmpty(description_val)) {

            DatabaseReference newPost = mDatabase.push();

            newPost.child("title").setValue(title_val);
            newPost.child("location").setValue(location_val);
            newPost.child("datetime").setValue(datetime_val);
            newPost.child("description").setValue(description_val);

            startActivity(new Intent(PostActivity.this, EventFeed.class ));
        }


    }
}
