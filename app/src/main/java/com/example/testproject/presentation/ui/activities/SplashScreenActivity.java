package com.example.testproject.presentation.ui.activities;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.example.testproject.App;
import com.example.testproject.R;
import com.example.testproject.data.sources.LocalDataSource;
import com.example.testproject.data.sources.LocalDataSourceImpl;
import com.example.testproject.data.sources.RemoteDataSourceImpl;
import com.example.testproject.data.sources.database.AppDatabase;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        LocalDataSource localDataSource = new LocalDataSourceImpl();
        localDataSource.setDatabase(
                Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database")
                        .build()
        );
        App.getRepository().setLocalSource(localDataSource);
        App.getRepository().setRemoteSource(new RemoteDataSourceImpl());

        MainActivity.startActivity(this);
        finish();
    }
}
