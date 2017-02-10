package com.gorevev.testapplication.presentation._common.injection;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ginko on 04.12.2016.
 */

@Module
public class DomainModule {
    public static final String JOB = "JOB";
    public static final String UI = "UI";

    @Provides
    @ScreenScope
    @Named(JOB)
    public Scheduler provideJobScheduler() {
        return Schedulers.newThread();
    }

    @Provides
    @ScreenScope
    @Named(UI)
    public Scheduler provideUIScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
