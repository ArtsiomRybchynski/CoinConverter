package com.example.testproject.data.sources.api;

import com.example.testproject.entities.RawResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("top/totalvolfull")
    Single<RawResponse> getResponseObject(@Query("limit") int lim, @Query("tsym") String currency);
}
