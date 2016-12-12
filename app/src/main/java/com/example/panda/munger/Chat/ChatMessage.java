package com.example.panda.munger.Chat;

public class ChatMessage {

    private String message;
    private String author;

    // Required default constructor for Firebase object mapping
    private ChatMessage() {
    }

    public ChatMessage(String message, String author) {
        this.message = message;
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthor() {
        return author;
    }
}
