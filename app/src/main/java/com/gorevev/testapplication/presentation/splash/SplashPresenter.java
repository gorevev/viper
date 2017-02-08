package com.gorevev.testapplication.presentation.splash;

import com.gorevev.testapplication.presentation.common.BasePresenter;

/**
 * Created by Ginko on 04.12.2016.
 */

public class SplashPresenter extends BasePresenter<ISplashView, ISplashRouter> implements ISplashPresenter {

    public SplashPresenter(ISplashRouter router) {
        this.setRouter(router);
    }

    @Override
    public void onStart() {

        getView().finishInitialization();
        getRouter().openLogin();
    }

    @Override
    public void onStop() {

    }
}
