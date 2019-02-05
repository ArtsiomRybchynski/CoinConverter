package com.example.testproject.repositories;

import com.example.testproject.api.RetrofitClient;
import com.example.testproject.entities.RawResponse;

import io.reactivex.Single;

public class RepositoryImpl implements Repository {


    @Override
    public Single<RawResponse> requestCoins() {
        return RetrofitClient.getInstance()
                .getApi()
                .getResponseObject();
    }
}
