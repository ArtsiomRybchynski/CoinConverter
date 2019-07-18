package com.example.testproject.source;

import com.example.testproject.source.local.LocalDataSource;
import com.example.testproject.source.remote.RemoteDataSource;
import com.example.testproject.entity.coin.Coin;
import com.example.testproject.entity.price.SinglePriceResponse;

import java.util.List;

import io.reactivex.Single;

public interface Repository {

    Single<List<Coin>> requestCoins();

    Single<Coin> getCoinById(int id);

    Single<List<Coin>> getAllCoins();

    Single<List<Coin>> getFilterCoins();

    Single<SinglePriceResponse> requestSinglePrice();

    void insertCoins(List<Coin> coins);

    void updateCoinTable(List<Coin> coins);

    void updateCoins(List<Coin> coins);

    void setRemoteSource(RemoteDataSource remoteSource);

    void setLocalSource(LocalDataSource localSource);
}
