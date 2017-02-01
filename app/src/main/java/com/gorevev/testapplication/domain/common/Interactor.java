package com.gorevev.testapplication.domain.common;

import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Ginko on 04.12.2016.
 */

public abstract class Interactor<ResultType, ParameterType> {

    private final CompositeSubscription subscriptions = new CompositeSubscription();

    protected final Scheduler jobScheduler;
    private final Scheduler uiScheduler;

    public Interactor(Scheduler jobScheduler, Scheduler uiScheduler) {
        this.jobScheduler = jobScheduler;
        this.uiScheduler = uiScheduler;
    }

    protected abstract Observable<ResultType> buildObservable(ParameterType parameter);

    public Observable<ResultType> execute(ParameterType parameter) {
        return buildObservable(parameter)
                .subscribeOn(jobScheduler)
                .observeOn(uiScheduler);
    }

    public Observable<ResultType> execute() {
        return execute(null);
    }

    public void subscribe(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public void unsubscribe() {
        subscriptions.clear();
    }
}