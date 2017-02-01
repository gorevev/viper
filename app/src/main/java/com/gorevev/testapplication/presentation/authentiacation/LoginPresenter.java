package com.gorevev.testapplication.presentation.authentiacation;

import com.gorevev.testapplication.domain.user.LoginInteractor;
import com.gorevev.testapplication.presentation.common.BasePresenter;
import com.gorevev.testapplication.domain.user.entity.LoginParams;

import javax.inject.Inject;

/**
 * Created by e.gorev on 30.01.2017.
 */

public class LoginPresenter extends BasePresenter<ILoginView, IAuthenticationRouter> implements ILoginPresenter {

    LoginInteractor loginInteractor;

    public LoginPresenter(IAuthenticationRouter router, LoginInteractor loginInteractor) {
        this.setRouter(router);
        this.loginInteractor = loginInteractor;
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
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
