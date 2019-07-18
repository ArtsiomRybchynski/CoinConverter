package com.example.testproject.entity.coin;

import com.example.testproject.entity.coin.Coin;
import com.example.testproject.entity.currency.Currencies;
import com.google.gson.annotations.SerializedName;

public class CoinDescription {

    @SerializedName("CoinInfo")
    private Coin coin;

    @SerializedName("DISPLAY")
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
