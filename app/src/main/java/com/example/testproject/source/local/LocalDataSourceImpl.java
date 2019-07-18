package com.example.testproject.source.local;

import com.example.testproject.database.AppDatabase;
import com.example.testproject.entity.coin.Coin;

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
    public Single<List<Coin>> getFilterCoins() {
        return database.coinDao().getFilterCoins();
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
    public void updateCoins(List<Coin> coins) {
        database.coinDao().updateCoins(coins);
    }

    @Override
    public void deleteAllCoins() {
        database.coinDao().deleteAllCoins();
    }
}
