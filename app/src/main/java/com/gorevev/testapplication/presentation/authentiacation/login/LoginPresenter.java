package com.gorevev.testapplication.presentation.authentiacation.login;

import com.arellomobile.mvp.InjectViewState;
import com.gorevev.testapplication.domain.user.LoginInteractor;
import com.gorevev.testapplication.domain.user.entities.LoginParams;
import com.gorevev.testapplication.infrastructure.exception.UnauthenticatedException;
import com.gorevev.testapplication.presentation._common.BasePresenter;

import javax.inject.Inject;


/**
 * Created by e.gorev on 30.01.2017.
 */
@InjectViewState
public class LoginPresenter extends BasePresenter<ILoginView, ILoginRouter> {

    LoginInteractor loginInteractor;

    @Inject
    public LoginPresenter(ILoginRouter router, LoginInteractor loginInteractor) {

        this.setRouter(router);
        this.loginInteractor = loginInteractor;
    }

    public void login(String login, String password) {

        LoginParams params = new LoginParams(login, password);

        getViewState().showProgress();

        loginInteractor.execute(params)
                .subscribe(
                        user -> {
                            getViewState().loggedIn();
                            getRouter().showMainScreen();
                        },
                        throwable -> {
                            getViewState().hideProgress();
                            handleError(throwable);
                        }
                );
    }

    public void onBackPressed() {
        router.back();
    }

    public void showRegistration() {
        router.showRegistration();
    }

    @Override
    protected void handleError(Throwable throwable) {
        if(throwable instanceof UnauthenticatedException) {
            getViewState().showUnauthenticatedError();
        } else {
            super.handleError(throwable);
        }
    }
}
