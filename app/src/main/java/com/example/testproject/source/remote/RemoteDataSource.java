package com.example.testproject.source.remote;

import com.example.testproject.entity.RawResponse;
import com.example.testproject.entity.price.SinglePriceResponse;

import io.reactivex.Single;

public interface RemoteDataSource {

    Single<RawResponse> requestCoins();

    Single<SinglePriceResponse> requestSinglePrice();
}
