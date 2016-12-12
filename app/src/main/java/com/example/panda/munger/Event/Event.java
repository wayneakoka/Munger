package com.example.panda.munger.Event;

/**
 * Created by paigemollison on 12/9/16.
 */

public class Event {

    private String title;
    private String location;
    private String datetime;
    private String description;

    public Event() {

    }

    public Event(String title, String location, String datetime, String description) {
        this.title = title;
        this.location = location;
        this.datetime = datetime;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
