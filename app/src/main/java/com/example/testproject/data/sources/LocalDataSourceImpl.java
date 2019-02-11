package com.example.testproject.data.sources;

import com.example.testproject.data.sources.database.AppDatabase;
import com.example.testproject.entities.Coin;

import java.util.List;
import io.reactivex.Single;

public class LocalDataSourceImpl implements LocalDataSource {

    private AppDatabase database;

    public void setDatabase(AppDatabase database) {
        this.database = database;
    }

    @Override
    public Single<Coin> getCoinById(int id) {
        return database.coinDao().getCoinById(id);
    }

    @Override
    public Single<List<Coin>> getAllCoins() {
        return database.coinDao().getAllCoins();
    }

    @Override
    public void insertCoins(List<Coin> coins) {
        database.coinDao().insertCoins(coins);
    }

    @Override
    public void updateCoinTable(List<Coin> coins) {
        database.coinDao().updateCoinTable(coins);
    }

    @Override
    public void deleteAllCoins() {
        database.coinDao().deleteAllCoins();
    }
}
