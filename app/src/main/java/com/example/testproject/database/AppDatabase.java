package com.example.testproject.database;

import com.example.testproject.database.dao.CoinDao;
import com.example.testproject.entity.coin.Coin;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = Coin.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CoinDao coinDao();
}
