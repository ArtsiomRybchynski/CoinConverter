package com.example.testproject.data.sources.database;

import com.example.testproject.entities.Coin;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import io.reactivex.Single;

@Dao
public abstract class CoinDao {

    @Insert
    public abstract void insertCoins(List<Coin> coins);

    @Query("SELECT * FROM coins")
    public abstract Single<List<Coin>> getAllCoins();

    @Query("SELECT * FROM coins WHERE id = :id")
    public abstract Single<Coin> getCoinById(int id);

    @Query("DELETE FROM coins")
    public abstract void deleteAllCoins();

    @Transaction
    public void updateCoinTable(List<Coin> coins) {
        deleteAllCoins();
        insertCoins(coins);
    }
}
