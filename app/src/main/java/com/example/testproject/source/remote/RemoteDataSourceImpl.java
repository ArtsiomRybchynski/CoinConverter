package com.example.testproject.source.remote;

import com.example.testproject.network.client.RetrofitClient;
import com.example.testproject.entity.RawResponse;
import com.example.testproject.entity.price.SinglePriceResponse;

import io.reactivex.Single;

public class RemoteDataSourceImpl implements RemoteDataSource {

    private static final int DEFAULT_COINS_LIMIT = 20;
    private static final String DEFAULT_CURRENCY = "USD";
    private static final String [] currencies = {"USD", "EUR", "BYN", "RUB"};

    @Override
    public Single<RawResponse> requestCoins() {
        return RetrofitClient.getInstance()
                .getApi()
                .getResponseObject(DEFAULT_COINS_LIMIT, DEFAULT_CURRENCY);
    }

    @Override
    public Single<SinglePriceResponse> requestSinglePrice() {
        return RetrofitClient.getInstance()
                .getApi()
                .getSinglePriceObject("BTC", currencies);
    }
}
