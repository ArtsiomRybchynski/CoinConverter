package com.example.testproject.api;

import com.example.testproject.entities.RawResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface Api {

    @GET("top/totalvolfull?limit=100&tsym=USD")
    Single<RawResponse> getResponseObject();
}
