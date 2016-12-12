package com.example.panda.munger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.panda.munger.Chat.ChatActivity;
import com.example.panda.munger.Event.EventFeed;
import com.example.panda.munger.Marketplace.ItemFeed;

public class socialFragment extends Fragment {

    Button chat;
    Button marketplace;
    Button event;



    public static socialFragment newInstance() {
        socialFragment fragment = new socialFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.socialfragment2, container, false);
        marketplace = (Button) rootView.findViewById(R.id.marketplace);
        chat = (Button) rootView.findViewById(R.id.chat);
        event = (Button) rootView.findViewById(R.id.event);


        marketplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ItemFeed.class);
                startActivity(intent);
            }
        });
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChatActivity.class);
                startActivity(intent);
            }
        });
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EventFeed.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}