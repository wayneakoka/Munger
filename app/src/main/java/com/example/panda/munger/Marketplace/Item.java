package com.example.panda.munger.Marketplace;

/**
 * Created by paigemollison on 12/9/16.
 */

public class Item {

    private String name;
    private String price;
    private String description;
    private String location;

    public Item() {

    }

    public Item (String name, String price, String description, String location) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
