package com.example.testproject.entities;

import com.google.gson.annotations.SerializedName;

public class CoinDescription {

    @SerializedName("CoinInfo")
    private Coin coin;

    @SerializedName("RAW")
    private Currencies currencies;

    public CoinDescription(Coin coin, Currencies currencies) {
        this.coin = coin;
        this.currencies = currencies;
    }

    public Coin getCoin() {
        return coin;
    }

    public Currencies getCurrencies() {
        return currencies;
    }
}
