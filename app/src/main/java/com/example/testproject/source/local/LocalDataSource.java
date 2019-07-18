package com.example.testproject.source.local;

import com.example.testproject.database.AppDatabase;
import com.example.testproject.entity.coin.Coin;

import java.util.List;

import io.reactivex.Single;

public interface LocalDataSource {

    void setDatabase(AppDatabase database);

    Single<Coin> getCoinById(int id);

    Single<List<Coin>> getAllCoins();

    Single<List<Coin>> getFilterCoins();

    void insertCoins(List<Coin> coins);

    void updateCoinTable(List<Coin> coins);

    void updateCoins(List<Coin> coins);

    void deleteAllCoins();
}
