package com.example.testproject.domain.entities;

import com.google.gson.annotations.SerializedName;

public class Coin {

    private static final String IMAGE_BASE_URL = "https://www.cryptocompare.com";

    @SerializedName("Name") private String name;
    @SerializedName("ImageUrl") private String imageUrl;
    @SerializedName("FullName") private String fullName;

    private double price;

    public Coin(String name, String imageUrl, String fullName) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return IMAGE_BASE_URL.concat(imageUrl);
    }

    public String getFullName() {
        return fullName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
