package com.gorevev.testapplication.domain.order;

import com.gorevev.testapplication.domain.common.Interactor;
import com.gorevev.testapplication.domain.common.entities.Response;
import com.gorevev.testapplication.domain.order.api.IOrderAPI;
import com.gorevev.testapplication.domain.order.entities.OrdersList;
import com.gorevev.testapplication.infrastructure.network.manager.NetworkConnectionManager;
import com.gorevev.testapplication.presentation._common.injection.DomainModule;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by e.gorev on 01.02.2017.
 */

public class GetOrdersInteractor extends Interactor<Response<OrdersList>, Map<String, String>> {

    private IOrderAPI service;

    @Inject
    public GetOrdersInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                               @Named(DomainModule.UI) Scheduler uiScheduler,
                               IOrderAPI service,
                               NetworkConnectionManager manager) {
        super(jobScheduler, uiScheduler, manager);
        this.service = service;
    }

    @Override
    protected Observable<Response<OrdersList>> buildObservable(Map<String, String> parameter) {
        return service.getOrders(parameter)
                .compose(convert());
    }
}
