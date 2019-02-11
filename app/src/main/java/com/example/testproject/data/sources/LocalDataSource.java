package com.example.testproject.data.sources;

import com.example.testproject.data.sources.database.AppDatabase;
import com.example.testproject.entities.Coin;

import java.util.List;

import io.reactivex.Single;

public interface LocalDataSource {

    void setDatabase(AppDatabase database);

    Single<Coin> getCoinById(int id);

    Single<List<Coin>> getAllCoins();

    void insertCoins(List<Coin> coins);

    void updateCoinTable(List<Coin> coins);

    void deleteAllCoins();

}
