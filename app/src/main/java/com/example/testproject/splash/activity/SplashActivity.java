package com.example.testproject.splash.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.example.testproject.App;
import com.example.testproject.R;
import com.example.testproject.source.local.LocalDataSource;
import com.example.testproject.source.local.LocalDataSourceImpl;
import com.example.testproject.source.remote.RemoteDataSourceImpl;
import com.example.testproject.database.AppDatabase;
import com.example.testproject.common.router.Router;

public class SplashActivity extends AppCompatActivity {

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

        Router.openMainActivity(this);
        finish();
    }
}
