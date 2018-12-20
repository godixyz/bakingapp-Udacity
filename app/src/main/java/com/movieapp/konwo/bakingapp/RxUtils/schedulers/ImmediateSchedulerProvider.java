package com.movieapp.konwo.bakingapp.RxUtils.schedulers;

import javax.annotation.Nullable;

import rx.Scheduler;
import rx.schedulers.Schedulers;

public class ImmediateSchedulerProvider implements BaseSchedulerProvider {
    @Nullable
    @Override
    public Scheduler computation() {
        return Schedulers.immediate();
    }

    @Nullable
    @Override
    public Scheduler io() {
        return Schedulers.immediate();
    }

    @Nullable
    @Override
    public Scheduler ui() {
        return Schedulers.immediate();
    }
}
