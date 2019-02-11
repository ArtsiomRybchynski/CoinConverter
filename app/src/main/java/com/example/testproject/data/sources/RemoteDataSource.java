package com.example.testproject.data.sources;

import com.example.testproject.entities.RawResponse;
import io.reactivex.Single;

public interface RemoteDataSource {

    Single<RawResponse> requestCoins();
}
