package com.gorevev.testapplication.domain.user;

import com.gorevev.testapplication.domain.common.Interactor;
import com.gorevev.testapplication.domain.common.entities.EmptyResponse;
import com.gorevev.testapplication.domain.common.entities.Response;
import com.gorevev.testapplication.domain.user.api.IUserAPI;
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
                                IUserAPI service) {
        super(jobScheduler, uiScheduler);
        this.service = service;
    }

    @Override
    protected Observable<EmptyResponse> buildObservable(Void parameter) {
        return service.smsCodeResend();
    }
}
