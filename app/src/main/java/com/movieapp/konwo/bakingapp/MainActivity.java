package com.movieapp.konwo.bakingapp;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import timber.log.Timber;

public class MainActivity extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

       if (BuildConfig.DEBUG) {
           Timber.uprootAll();
           Timber.plant(new Timber.DebugTree());
       }

    }
}
