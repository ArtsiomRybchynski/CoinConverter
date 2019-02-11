package com.example.testproject.data;

import com.example.testproject.data.sources.LocalDataSource;
import com.example.testproject.data.sources.RemoteDataSource;
import com.example.testproject.entities.Coin;

import java.util.List;

import io.reactivex.Single;

public interface Repository {

    Single<List<Coin>> requestCoins();

    Single<Coin> getCoinById(int id);

    Single<List<Coin>> getAllCoins();

    void insertCoins(List<Coin> coins);

    void updateCoinTable(List<Coin> coins);


    void setRemoteSource(RemoteDataSource remoteSource);
    void setLocalSource(LocalDataSource localSource);
}
