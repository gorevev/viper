package com.gorevev.testapplication.presentation.splash;

import com.arellomobile.mvp.InjectViewState;
import com.gorevev.testapplication.presentation.common.BasePresenter;

/**
 * Created by Ginko on 04.12.2016.
 */

@InjectViewState
public class SplashPresenter extends BasePresenter<ISplashView, ISplashRouter> {

    public SplashPresenter(ISplashRouter router) {
        this.setRouter(router);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        init();
    }

    public void init() {
        getViewState().finishInitialization();
        getRouter().openLogin();
    }
}
