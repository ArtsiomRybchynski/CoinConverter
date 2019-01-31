package com.example.testproject.data.repositories;

import com.example.testproject.domain.entities.ResponseObject;

import io.reactivex.Single;

public interface Repository {

    Single<ResponseObject> requestCoins();
}
