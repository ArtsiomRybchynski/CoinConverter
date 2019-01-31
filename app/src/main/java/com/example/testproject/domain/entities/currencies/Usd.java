package com.example.testproject.domain.entities.currencies;

import com.google.gson.annotations.SerializedName;

public class Usd {

    @SerializedName("PRICE") private double price;

    public Usd(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
