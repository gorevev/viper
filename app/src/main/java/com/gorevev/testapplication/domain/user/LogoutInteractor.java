package com.gorevev.testapplication.domain.user;

import android.util.Log;

import com.gorevev.testapplication.domain.common.Interactor;
import com.gorevev.testapplication.infrastructure.repository.RepositoryException;
import com.gorevev.testapplication.infrastructure.repository.storages.TokenStorage;
import com.gorevev.testapplication.presentation.common.injection.DomainModule;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by e.gorev on 02.02.2017.
 */

public class LogoutInteractor extends Interactor<Void, Void> {

    private static final String TAG = LoginInteractor.class.getName();

    @Inject
    TokenStorage tokenStorage;

    @Inject
    public LogoutInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                            @Named(DomainModule.UI) Scheduler uiScheduler) {
        super(jobScheduler, uiScheduler);
    }

    @Override
    protected Observable<Void> buildObservable(Void parameter) {
        return Observable.create(subscriber -> {
            try {
                tokenStorage.put(null);
                subscriber.onNext(null);
            } catch (RepositoryException e) {
                Log.e(TAG, e.getMessage());
                subscriber.onError(e);
            }
        });
    }
}
