package com.gorevev.testapplication.presentation.main;

import com.arellomobile.mvp.InjectViewState;
import com.gorevev.testapplication.domain._common.entities.Response;
import com.gorevev.testapplication.domain.user.LoginInteractor;
import com.gorevev.testapplication.domain.user.LogoutInteractor;
import com.gorevev.testapplication.domain.user.entities.LoginParams;
import com.gorevev.testapplication.domain.user.entities.Token;
import com.gorevev.testapplication.infrastructure.exceptions.ErrorResolver;
import com.gorevev.testapplication.presentation._common.BasePresenter;

import javax.inject.Inject;

import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by denischuvasov on 10.02.17.
 */

@InjectViewState
public class MainPresenter extends BasePresenter<IMainView, IMainRouter> {

    LogoutInteractor logoutInteractor;

    LoginInteractor loginInteractor;

    @Inject
    public MainPresenter(IMainRouter router, LogoutInteractor logoutInteractor, LoginInteractor loginInteractor, ErrorResolver errorResolver) {
        super(router, errorResolver);
        this.logoutInteractor = logoutInteractor;
        this.loginInteractor = loginInteractor;

        showOrders();
    }

    public void showOrders() {
        getRouter().showOrders();
        getViewState().closeSideMenu();
    }

    public void showSearchOrders() {
        //getRouter().showSearchOrders();
        loginInteractor.execute(new LoginParams("k.kurilo@mail.ru", "12345")).subscribe(
                response -> {},
                throwable -> handleError(throwable)
        );
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
           //getRouter().showAuthentication();
        });
    }
}
