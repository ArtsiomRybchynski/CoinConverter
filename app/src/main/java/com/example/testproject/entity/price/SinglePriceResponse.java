package com.example.testproject.entity.price;

import com.google.gson.annotations.SerializedName;

public class SinglePriceResponse {

    @SerializedName("USD")
    private double usdPrice;

    @SerializedName("EUR")
    private double eurPrice;

    @SerializedName("BYN")
    private double bynPrice;

    @SerializedName("RUB")
    private double rubPrice;

    public double getUsdPrice() {
        return usdPrice;
    }

    public void setUsdPrice(double usdPrice) {
        this.usdPrice = usdPrice;
    }

    public double getEurPrice() {
        return eurPrice;
    }

    public void setEurPrice(double eurPrice) {
        this.eurPrice = eurPrice;
    }

    public double getBynPrice() {
        return bynPrice;
    }

    public void setBynPrice(double bynPrice) {
        this.bynPrice = bynPrice;
    }

    public double getRubPrice() {
        return rubPrice;
    }

    public void setRubPrice(double rubPrice) {
        this.rubPrice = rubPrice;
    }
}
