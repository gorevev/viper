package com.gorevev.testapplication.presentation._common;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import com.gorevev.testapplication.presentation._common.resolution.IThrowableResolver;

public abstract class BasePresenter<View extends MvpView, Router extends IBaseRouter> extends MvpPresenter<View> {

    protected Router router;
    private IThrowableResolver resolver;

    public void setRouter(Router router) {
        this.router = router;
    }

    public Router getRouter() {
        return router;
    }

    public void onBackPressed() {
        router.back();
    }

    protected void handleError(Throwable throwable) {
        if(resolver != null)
            resolver.handleError(throwable);
    }

    public void setThrowableResolver(IThrowableResolver resolver) {
        this.resolver = resolver;
    }
}
