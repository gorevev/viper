package com.gorevev.testapplication.domain._common;

import com.gorevev.testapplication.domain._common.entities.Response;
import com.gorevev.testapplication.infrastructure.network.manager.NetworkConnectionManager;
import com.gorevev.testapplication.infrastructure.rx.RxRestApiFunctions;

import rx.Observable;
import rx.Observable.Transformer;
import rx.Scheduler;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Ginko on 04.12.2016.
 */

public abstract class Interactor<ResultType, ParameterType> {

    private final CompositeSubscription subscriptions = new CompositeSubscription();

    private final Scheduler jobScheduler;
    private final Scheduler uiScheduler;
    private final NetworkConnectionManager manager;

    public Interactor(Scheduler jobScheduler, Scheduler uiScheduler, NetworkConnectionManager manager) {
        this.jobScheduler = jobScheduler;
        this.uiScheduler = uiScheduler;
        this.manager = manager;
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

    protected <T extends Response<?>> Transformer<T, T> convert() {
        return observable -> observable.onBackpressureDrop()
                .subscribeOn(jobScheduler)
                .retryWhen(RxRestApiFunctions.networkNotAvailableRetry(observable, manager));
    }
}