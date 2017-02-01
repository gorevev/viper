package com.gorevev.testapplication.presentation.common;

public abstract class BasePresenter<View, Router> implements IBasePresenter<View, Router> {

    private View view;
    private Router router;

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Router getRouter() {
        return router;
    }

    public void setRouter(Router router) {
        this.router = router;
    }
}


