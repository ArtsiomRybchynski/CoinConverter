package com.example.testproject.entities;

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
