package com.example.testproject.data.sources;

import com.example.testproject.data.sources.api.RetrofitClient;
import com.example.testproject.entities.RawResponse;

import io.reactivex.Single;

public class RemoteDataSourceImpl implements RemoteDataSource {

    private static final int DEFAULT_COINS_LIMIT = 100;
    private static final String DEFAULT_CURRENCY = "USD";
    @Override
    public Single<RawResponse> requestCoins() {
        return RetrofitClient.getInstance()
                .getApi()
                .getResponseObject(DEFAULT_COINS_LIMIT, DEFAULT_CURRENCY);
    }
}
