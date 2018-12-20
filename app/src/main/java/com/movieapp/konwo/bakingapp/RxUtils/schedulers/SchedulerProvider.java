package com.movieapp.konwo.bakingapp.RxUtils.schedulers;

import javax.annotation.Nullable;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SchedulerProvider implements BaseSchedulerProvider {

    @Nullable
    private static SchedulerProvider INSTANCE;

    //prevent direct instantiation

    private SchedulerProvider() {

    }

    public static synchronized SchedulerProvider getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SchedulerProvider();
        }
        return INSTANCE;
    }

    @Nullable
    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Nullable
    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Nullable
    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
