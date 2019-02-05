package com.example.testproject.entities;

import com.example.testproject.entities.currencies.UsdCurrency;
import com.google.gson.annotations.SerializedName;

public class Currencies {

    @SerializedName("USD")
    private UsdCurrency usdCurrency;

    public Currencies(UsdCurrency usdCurrency) {
        this.usdCurrency = usdCurrency;
    }

    public UsdCurrency getUsdCurrency() {
        return usdCurrency;
    }
}
