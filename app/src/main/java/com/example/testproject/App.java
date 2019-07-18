package com.example.testproject;

import android.app.Application;

import com.example.testproject.source.Repository;
import com.example.testproject.source.RepositoryImpl;

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
