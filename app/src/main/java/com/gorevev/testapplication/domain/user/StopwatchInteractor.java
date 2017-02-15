package com.gorevev.testapplication.domain.user;

import com.gorevev.testapplication.domain.common.Interactor;
import com.gorevev.testapplication.presentation._common.injection.DomainModule;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by denischuvasov on 15.02.17.
 */

public class StopwatchInteractor extends Interactor<Long, Integer> {

    @Inject
    public StopwatchInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                               @Named(DomainModule.UI) Scheduler uiScheduler) {
        super(jobScheduler, uiScheduler);
    }

    @Override
    protected Observable<Long> buildObservable(Integer delay) {
        return Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(delay + 1);
    }
}
