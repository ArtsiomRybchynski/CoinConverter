package com.example.testproject.data.utils;

import com.example.testproject.data.web.Api;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://min-api.cryptocompare.com/data/";
    private static RetrofitClient sInstance;
    private Retrofit retrofit;

    private RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance() {
        if (sInstance == null) {
            sInstance = new RetrofitClient();
        }
        return sInstance;
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }
}
