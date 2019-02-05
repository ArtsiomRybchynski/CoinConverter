package com.example.testproject.repositories;

import com.example.testproject.entities.RawResponse;

import io.reactivex.Single;

public interface Repository {

    Single<RawResponse> requestCoins();
}
