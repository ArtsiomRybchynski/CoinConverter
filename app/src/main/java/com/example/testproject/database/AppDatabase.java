package com.example.testproject.database;

import com.example.testproject.entities.Coin;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = Coin.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CoinDao coinDao();
}
