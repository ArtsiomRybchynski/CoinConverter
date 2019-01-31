package com.example.testproject.data.repositories;

import com.example.testproject.data.utils.RetrofitClient;
import com.example.testproject.domain.entities.ResponseObject;

import io.reactivex.Single;

public class RepositoryImpl implements Repository {


    @Override
    public Single<ResponseObject> requestCoins() {
        return RetrofitClient.getInstance()
                .getApi()
                .getResponseObject();
    }
}
