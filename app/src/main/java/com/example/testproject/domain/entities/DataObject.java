package com.example.testproject.domain.entities;

import com.google.gson.annotations.SerializedName;

public class DataObject {

    @SerializedName("CoinInfo") private Coin coin;
    @SerializedName("RAW") private Currency currency;

    public DataObject(Coin coin, Currency currency) {
        this.coin = coin;
        this.currency = currency;
    }

    public Coin getCoin() {
        return coin;
    }

    public Currency getCurrency() {
        return currency;
    }
}
