package com.example.testproject;

import android.app.Application;

import com.example.testproject.data.Repository;
import com.example.testproject.data.RepositoryImpl;

public class App extends Application {

    private static Repository repository;

    @Override
    public void onCreate() {
        super.onCreate();
        repository = new RepositoryImpl(this);
    }

    public static Repository getRepository() {
        return repository;
    }
}
