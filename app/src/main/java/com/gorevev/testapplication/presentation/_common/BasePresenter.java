package com.gorevev.testapplication.presentation._common;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

public abstract class BasePresenter<View extends MvpView, Router extends IBaseRouter> extends MvpPresenter<View> {
    protected Router router;

    public void setRouter(Router router) {
        this.router = router;
    }

    public Router getRouter() {
        return router;
    }

    public void onBackPressed() {
        router.back();
    }
}
