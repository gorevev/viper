package com.gorevev.testapplication.domain.order;


import com.gorevev.testapplication.domain.common.Interactor;
import com.gorevev.testapplication.domain.common.entities.Response;
import com.gorevev.testapplication.domain.order.api.IOrderAPI;
import com.gorevev.testapplication.domain.order.entities.OrderContainer;
import com.gorevev.testapplication.infrastructure.network.manager.NetworkConnectionManager;
import com.gorevev.testapplication.presentation._common.injection.DomainModule;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by denischuvasov on 23.01.17.
 */

public class OrderDetailsInteractor extends Interactor<Response<OrderContainer>, Integer> {
    private final IOrderAPI service;

    @Inject
    public OrderDetailsInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                                  @Named(DomainModule.UI) Scheduler uiScheduler,
                                  IOrderAPI service,
                                  NetworkConnectionManager manager) {
        super(jobScheduler, uiScheduler, manager);
        this.service = service;
    }


    @Override
    protected Observable<Response<OrderContainer>> buildObservable(Integer id) {
        return service.order(id)
                .compose(convert());
    }
}