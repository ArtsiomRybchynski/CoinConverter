package com.example.testproject.database;

import com.example.testproject.entities.Coin;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import io.reactivex.Single;

@Dao
public interface CoinDao {

    @Insert
    void insertCoins(List<Coin> coins);

    @Query("SELECT * FROM coins")
    Single<List<Coin>> getAllCoins();

    @Query("SELECT * FROM coins WHERE id = :id")
    Single<Coin> getCoinById(int id);

    @Update
    void updateCoins(List<Coin> coins);
}
