package com.example.testproject.entity;

import com.example.testproject.entity.coin.CoinDescription;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RawResponse {

    @SerializedName("Data")
    private List<CoinDescription> coinDescriptions;

    public RawResponse(List<CoinDescription> coinDescriptions) {
        this.coinDescriptions = coinDescriptions;
    }

    public List<CoinDescription> getCoinDescriptions() {
        return coinDescriptions;
    }
}
