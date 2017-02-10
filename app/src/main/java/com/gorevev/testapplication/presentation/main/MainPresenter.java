package com.gorevev.testapplication.presentation.main;

import com.arellomobile.mvp.InjectViewState;
import com.gorevev.testapplication.domain.user.LogoutInteractor;
import com.gorevev.testapplication.presentation._common.BasePresenter;

import javax.inject.Inject;

/**
 * Created by denischuvasov on 10.02.17.
 */

@InjectViewState
public class MainPresenter extends BasePresenter<IMainView, IMainRouter> {

    LogoutInteractor logoutInteractor;

    @Inject
    public MainPresenter(IMainRouter router, LogoutInteractor logoutInteractor) {
        setRouter(router);
        this.logoutInteractor = logoutInteractor;
        showOrders();
    }

    public void showOrders() {
        getRouter().showOrders();
        getViewState().closeSideMenu();
    }

    public void showSearchOrders() {
        getRouter().showSearchOrders();
        getViewState().closeSideMenu();
    }

    public void onBackPressed(boolean drawerOpen) {
        if (drawerOpen) {
            getViewState().closeSideMenu();
        } else {
            router.back();
        }
    }

    public void logout() {
        logoutInteractor.execute().subscribe(aVoid -> {
           getRouter().showAuthentication();
        });
    }
}
