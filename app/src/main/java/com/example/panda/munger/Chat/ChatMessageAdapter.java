package com.example.panda.munger.Chat;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChatMessageAdapter extends RecyclerView.Adapter<ChatMessageAdapter.ChatMessageViewHolder> {

    private static final String TAG = "ChatMessageAdapter";
    private final Activity activity;
    List<ChatMessage> messages = new ArrayList<>();
    private String author;

    public ChatMessageAdapter(Activity activity) {
        this.activity = activity;
    }

    public void addMessage(ChatMessage chat) {
        messages.add(chat);
        author = chat.getAuthor();
        notifyItemInserted(messages.size());
    }



    @Override
    public ChatMessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChatMessageViewHolder(activity, activity.getLayoutInflater().inflate(android.R.layout.two_line_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ChatMessageViewHolder holder, int position) {
        holder.bind(messages.get(position));
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }


    public class ChatMessageViewHolder extends RecyclerView.ViewHolder {
        private final Activity activity;

        TextView name, message;

        public ChatMessageViewHolder(Activity activity, View itemView) {
            super(itemView);
            this.activity = activity;
            name = (TextView) itemView.findViewById(android.R.id.text1);
            message = (TextView) itemView.findViewById(android.R.id.text2);
        }

        //Bind data model with View
        public void bind(ChatMessage chat) {
            name.setText(chat.getAuthor());
            //Message is an image
            if (chat.getMessage().startsWith("https://firebasestorage.googleapis.com/") || chat.getMessage().startsWith("content://")) {
                message.setVisibility(View.INVISIBLE);

            } else {
                message.setVisibility(View.VISIBLE);
                message.setText(chat.getMessage());
            }
        }
    }
}