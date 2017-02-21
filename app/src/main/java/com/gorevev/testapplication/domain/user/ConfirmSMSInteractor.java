package com.gorevev.testapplication.domain.user;

import com.gorevev.testapplication.domain.common.Interactor;
import com.gorevev.testapplication.domain.common.entities.EmptyResponse;
import com.gorevev.testapplication.domain.common.entities.Response;
import com.gorevev.testapplication.domain.user.api.IUserAPI;
import com.gorevev.testapplication.domain.user.entities.LoginParams;
import com.gorevev.testapplication.domain.user.entities.SmsConfirmationCode;
import com.gorevev.testapplication.domain.user.entities.Token;
import com.gorevev.testapplication.infrastructure.network.manager.NetworkConnectionManager;
import com.gorevev.testapplication.presentation._common.injection.DomainModule;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by denischuvasov on 14.02.17.
 */

public class ConfirmSMSInteractor extends Interactor<EmptyResponse, SmsConfirmationCode> {

    private final IUserAPI service;

    @Inject
    public ConfirmSMSInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                                @Named(DomainModule.UI) Scheduler uiScheduler,
                                IUserAPI service,
                                NetworkConnectionManager manager) {
        super(jobScheduler, uiScheduler, manager);
        this.service = service;
    }


    @Override
    protected Observable<EmptyResponse> buildObservable(SmsConfirmationCode parameter) {
        return service.smsCodeConfirm(parameter)
                .compose(convert());
    }
}
