package com.gorevev.testapplication.presentation._common;

import com.arellomobile.mvp.MvpPresenter;
import com.gorevev.testapplication.infrastructure.exceptions.ErrorResolver;

import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BasePresenter<View extends IBaseView, Router extends IBaseRouter> extends MvpPresenter<View> {

    protected Router router;

    @Inject
    public ErrorResolver errorResolver;

    public BasePresenter(Router router, ErrorResolver errorResolver) {
        this.router = router;
        this.errorResolver = errorResolver;
    }

    public void onBackPressed() {
        router.back();
    }

    protected void handleError(Throwable throwable) {
        if (errorResolver != null && !errorResolver.handleError(throwable, getViewState(), getRouter()))
            getViewState().showSnackbar(throwable);
    }
}
