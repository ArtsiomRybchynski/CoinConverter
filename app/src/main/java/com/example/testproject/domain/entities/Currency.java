package com.example.testproject.domain.entities;

import com.example.testproject.domain.entities.currencies.Usd;
import com.google.gson.annotations.SerializedName;

public class Currency {

    @SerializedName("USD") private Usd usd;

    public Currency(Usd usd) {
        this.usd = usd;
    }

    public Usd getUsd() {
        return usd;
    }
}
