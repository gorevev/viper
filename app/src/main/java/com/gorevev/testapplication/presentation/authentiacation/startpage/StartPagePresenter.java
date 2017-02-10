package com.gorevev.testapplication.presentation.authentiacation.startpage;

import com.arellomobile.mvp.InjectViewState;
import com.gorevev.testapplication.presentation._common.BasePresenter;

import javax.inject.Inject;

@InjectViewState
public class StartPagePresenter extends BasePresenter<IStartPageView, IStartPageRouter> {

    @Inject
    public StartPagePresenter(IStartPageRouter router) {
        setRouter(router);
    }

    public void showLogin() {
        router.showLogin();
    }

    public void showRegistration() {
        router.showRegistration();
    }

    public void onBackPressed() {
        router.back();
    }
}
