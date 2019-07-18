package com.example.testproject.entity.currency;

import com.google.gson.annotations.SerializedName;

public class UsdCurrency {

    @SerializedName("PRICE")
    private String price;

    public UsdCurrency(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }
}
