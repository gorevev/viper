package com.gorevev.testapplication.presentation.splash;

import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;
import com.gorevev.testapplication.infrastructure.exceptions.ErrorResolver;
import com.gorevev.testapplication.infrastructure.storages.TokenStorage;
import com.gorevev.testapplication.presentation._common.BasePresenter;

import javax.inject.Inject;

/**
 * Created by Ginko on 04.12.2016.
 */

@InjectViewState
public class SplashPresenter extends BasePresenter<ISplashView, ISplashRouter> {

    private final TokenStorage storage;

    @Inject
    SplashPresenter(ISplashRouter router, TokenStorage storage, ErrorResolver errorResolver) {
        super(router, errorResolver);

        this.storage = storage;
    }

    @Override
    protected void onFirstViewAttach() {

        super.onFirstViewAttach();
        init();
    }

    private void init() {

        getViewState().finishInitialization();
        if(TextUtils.isEmpty(storage.get())) {
            getRouter().showAuthentication();
        } else {
            getRouter().showMainScreen();
        }
    }
}
