package com.gorevev.testapplication.domain.user;

import android.util.Log;

import com.gorevev.testapplication.domain.common.Interactor;
import com.gorevev.testapplication.infrastructure.repository.IRepository;
import com.gorevev.testapplication.infrastructure.repository.RepositoryException;
import com.gorevev.testapplication.infrastructure.repository.storages.TokenStorage;
import com.gorevev.testapplication.presentation.common.injection.DomainModule;
import com.gorevev.testapplication.domain.user.api.IUserAPI;
import com.gorevev.testapplication.domain.user.entities.LoginParams;
import com.gorevev.testapplication.domain.user.entities.User;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.observables.BlockingObservable;

/**
 * Created by e.gorev on 30.01.2017.
 */

public class LoginInteractor extends Interactor<User, LoginParams> {

    private static final String TAG = LoginInteractor.class.getName();

    private IUserAPI service;

    @Inject
    TokenStorage storage;

    @Inject
    public LoginInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                           @Named(DomainModule.UI) Scheduler uiScheduler,
                           IUserAPI service) {
        super(jobScheduler, uiScheduler);
        this.service = service;
    }

    @Override
    protected Observable<User> buildObservable(LoginParams parameters) {
        return service.login(parameters)
                .map(user -> {

                    try {
                        storage.put(user.getData().token);
                    } catch (RepositoryException e) {
                        Log.e(TAG, e.getMessage());
                    }

                    return user;
                });
    }
}
