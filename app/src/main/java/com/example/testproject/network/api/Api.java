package com.example.testproject.network.api;

import com.example.testproject.entity.RawResponse;
import com.example.testproject.entity.price.SinglePriceResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("top/totalvolfull")
    Single<RawResponse> getResponseObject(@Query("limit") int lim, @Query("tsym") String currency);

    @GET("price")
    Single<SinglePriceResponse> getSinglePriceObject(@Query("fsym") String coin,
                                                     @Query("tsyms") String [] currencies);
}
