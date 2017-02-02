package com.gorevev.testapplication.presentation.authentiacation;

import com.gorevev.testapplication.domain.user.LoginInteractor;
import com.gorevev.testapplication.domain.user.LogoutInteractor;
import com.gorevev.testapplication.presentation.common.BasePresenter;
import com.gorevev.testapplication.domain.user.entities.LoginParams;

import rx.functions.Action1;

/**
 * Created by e.gorev on 30.01.2017.
 */

public class LoginPresenter extends BasePresenter<ILoginView, IAuthenticationRouter> implements ILoginPresenter {

    LoginInteractor loginInteractor;

    LogoutInteractor logoutInteractor;

    public LoginPresenter(IAuthenticationRouter router, LoginInteractor loginInteractor, LogoutInteractor logoutInteractor) {

        this.setRouter(router);
        this.loginInteractor = loginInteractor;
        this.logoutInteractor = logoutInteractor;
    }

    @Override
    public void login(String login, String password) {

        LoginParams params = new LoginParams();
        params.setLogin(login);
        params.setPassword(password);

        loginInteractor.execute(params)
                .subscribe(
                        user -> {
                            getView().loggedIn();
                            getRouter().showRoutesList();
                        },
                        throwable -> getView().showError(throwable.getMessage())
                );
    }

    @Override
    public void logout() {

        logoutInteractor.execute()
                .subscribe(
                        aVoid -> {
                            getView().loggedOut();
                });
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
