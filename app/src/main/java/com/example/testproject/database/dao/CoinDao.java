package com.example.testproject.database.dao;

import com.example.testproject.entity.coin.Coin;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
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

    @Query("SELECT * FROM coins WHERE isNotShown = 0")
    public abstract Single<List<Coin>> getFilterCoins();

    @Update
    public abstract void updateCoins(List<Coin> coins);

    @Transaction
    public void updateCoinTable(List<Coin> coins) {
        deleteAllCoins();
        insertCoins(coins);
    }
}
