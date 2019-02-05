package com.example.testproject.entities.currencies;

import com.google.gson.annotations.SerializedName;

public class UsdCurrency {

    @SerializedName("PRICE")
    private double price;

    public UsdCurrency(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
