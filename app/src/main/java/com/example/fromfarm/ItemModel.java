package com.example.fromfarm;

public class ItemModel {
    private String imageURL;
    private String name;
    private String price;

    public ItemModel(String imageURL, String name, String price) {
        this.imageURL = imageURL;
        this.name = name;
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
