package com.example.panda.munger.Marketplace;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.panda.munger.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ItemFeed extends AppCompatActivity {

    private RecyclerView mEventList;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemactivity);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Marketplace");

        mEventList = (RecyclerView) findViewById(R.id.item_list);
        mEventList.setHasFixedSize(true);
        mEventList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Item, EventViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Item, EventViewHolder>(

                Item.class,
                R.layout.item_row,
                EventViewHolder.class,
                mDatabase

        ) {
            @Override
            protected void populateViewHolder(EventViewHolder viewHolder, Item model, int position) {

                final String post_key = getRef(position).getKey();

                viewHolder.setTitle(model.getName());
                viewHolder.setPrice(model.getPrice());
                viewHolder.setLocation(model.getLocation());
                viewHolder.setDescription(model.getDescription());

                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent singleEventIntent = new Intent(ItemFeed.this, ItemSingleActivity.class);
                        singleEventIntent.putExtra("item_id", post_key);
                        startActivity(singleEventIntent);

                        //Toast.makeText(MainActivity.this, post_key, Toast.LENGTH_SHORT).show();

                    }
                });
            }
        };

        mEventList.setAdapter(firebaseRecyclerAdapter);

    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public EventViewHolder(View itemView) {
            super(itemView);

            mView = itemView;


        }

        public void setTitle(String title) {

            TextView event_title = (TextView) mView.findViewById(R.id.event_title);
            event_title.setText(title);

        }

        public void setLocation(String location) {

            TextView event_location = (TextView) mView.findViewById(R.id.event_location);
            event_location.setText(location);
        }

        public void setPrice(String price) {

            TextView event_price = (TextView) mView.findViewById(R.id.event_price);
            event_price.setText(price);
        }

        public void setDescription(String description) {

            TextView event_description = (TextView) mView.findViewById(R.id.event_description);
            event_description.setText(description);
        }

    }


    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.eventmenu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_add) {

            startActivity(new Intent(ItemFeed.this, PostActivity.class));

        }

        return super.onOptionsItemSelected(item);
    }
}
