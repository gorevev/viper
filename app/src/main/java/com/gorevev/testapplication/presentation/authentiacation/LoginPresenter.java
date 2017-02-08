package com.gorevev.testapplication.presentation.authentiacation;

import com.arellomobile.mvp.InjectViewState;
import com.gorevev.testapplication.domain.user.LoginInteractor;
import com.gorevev.testapplication.domain.user.LogoutInteractor;
import com.gorevev.testapplication.domain.user.entities.LoginParams;
import com.gorevev.testapplication.presentation.common.BasePresenter;


/**
 * Created by e.gorev on 30.01.2017.
 */
@InjectViewState
public class LoginPresenter extends BasePresenter<ILoginView, IAuthenticationRouter> {

    LoginInteractor loginInteractor;

    LogoutInteractor logoutInteractor;

    public LoginPresenter(IAuthenticationRouter router, LoginInteractor loginInteractor, LogoutInteractor logoutInteractor) {

        this.setRouter(router);
        this.loginInteractor = loginInteractor;
        this.logoutInteractor = logoutInteractor;
    }

    public void login(String login, String password) {

        LoginParams params = new LoginParams(login, password);

        getViewState().showProgress();

        loginInteractor.execute(params)
                .subscribe(
                        user -> {
                            getViewState().loggedIn();
                            getRouter().showOrders();
                            loginInteractor.release();
                        },
                        throwable -> {
                            getViewState().hideProgress();
                            getViewState().showError(throwable.getMessage());
                            loginInteractor.release();
                        }
                );
    }

    public void logout() {

        logoutInteractor.execute()
                .subscribe(
                        aVoid -> {
                            getViewState().loggedOut();
                });
    }
}
