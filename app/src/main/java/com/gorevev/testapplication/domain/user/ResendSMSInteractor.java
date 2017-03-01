package com.gorevev.testapplication.domain.user;

import com.gorevev.testapplication.domain._common.Interactor;
import com.gorevev.testapplication.domain._common.entities.EmptyResponse;
import com.gorevev.testapplication.domain.user.api.IUserAPI;
import com.gorevev.testapplication.infrastructure.network.manager.NetworkConnectionManager;
import com.gorevev.testapplication.presentation._common.injection.DomainModule;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by denischuvasov on 14.02.17.
 */

public class ResendSMSInteractor extends Interactor<EmptyResponse, Void> {

    private final IUserAPI service;

    @Inject
    public ResendSMSInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                                @Named(DomainModule.UI) Scheduler uiScheduler,
                                IUserAPI service,
                               NetworkConnectionManager manager) {
        super(jobScheduler, uiScheduler, manager);
        this.service = service;
    }

    @Override
    protected Observable<EmptyResponse> buildObservable(Void parameter) {
        return service.smsCodeResend()
                .compose(convert());
    }
}
