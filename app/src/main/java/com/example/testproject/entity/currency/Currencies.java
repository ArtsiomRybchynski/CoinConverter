package com.example.testproject.entity.currency;

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
