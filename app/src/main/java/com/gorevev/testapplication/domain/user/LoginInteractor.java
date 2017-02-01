package com.gorevev.testapplication.domain.user;

import com.gorevev.testapplication.domain.common.Interactor;
import com.gorevev.testapplication.presentation.common.injection.DomainModule;
import com.gorevev.testapplication.domain.user.api.IUserAPI;
import com.gorevev.testapplication.domain.user.entity.LoginParams;
import com.gorevev.testapplication.domain.user.entity.User;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by e.gorev on 30.01.2017.
 */

public class LoginInteractor extends Interactor<User, LoginParams> {

    private IUserAPI service;

    @Inject
    public LoginInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                           @Named(DomainModule.UI) Scheduler uiScheduler,
                           IUserAPI service) {
        super(jobScheduler, uiScheduler);
        this.service = service;
    }

    @Override
    protected Observable<User> buildObservable(LoginParams parameters) {
        return service.login(parameters);
    }
}
