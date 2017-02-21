package com.gorevev.testapplication.domain.user;

import android.util.Log;

import com.gorevev.testapplication.domain.common.Interactor;
import com.gorevev.testapplication.domain.common.entities.Response;
import com.gorevev.testapplication.infrastructure.network.manager.NetworkConnectionManager;
import com.gorevev.testapplication.infrastructure.repository.RepositoryException;
import com.gorevev.testapplication.infrastructure.storages.TokenStorage;
import com.gorevev.testapplication.presentation._common.injection.DomainModule;
import com.gorevev.testapplication.domain.user.api.IUserAPI;
import com.gorevev.testapplication.domain.user.entities.LoginParams;
import com.gorevev.testapplication.domain.user.entities.Token;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by e.gorev on 30.01.2017.
 */

public class LoginInteractor extends Interactor<Response<Token>, LoginParams> {

    private static final String TAG = LoginInteractor.class.getName();

    private IUserAPI service;

    @Inject
    TokenStorage storage;

    @Inject
    public LoginInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                           @Named(DomainModule.UI) Scheduler uiScheduler,
                           IUserAPI service,
                           NetworkConnectionManager manager) {
        super(jobScheduler, uiScheduler, manager);
        this.service = service;
    }

    @Override
    protected Observable<Response<Token>> buildObservable(LoginParams parameters) {
        return service.login(parameters)
                .compose(convert())
                .map(response -> {

                    try {
                        storage.put(response.getData().getToken());
                    } catch (RepositoryException e) {
                        Log.e(TAG, e.getMessage());
                    }

                    return response;
                });
    }
}
