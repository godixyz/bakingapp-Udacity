package com.movieapp.konwo.bakingapp.RxUtils.schedulers;

import javax.annotation.Nullable;

import rx.Scheduler;

public interface BaseSchedulerProvider {

    @Nullable
    Scheduler computation();

    @Nullable
    Scheduler io();

    @Nullable
    Scheduler ui();
}
