package com.example.testproject.data.web;

import com.example.testproject.domain.entities.ResponseObject;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface Api {

    @GET("top/totalvolfull?limit=100&tsym=USD")
    Single<ResponseObject> getResponseObject();
}
