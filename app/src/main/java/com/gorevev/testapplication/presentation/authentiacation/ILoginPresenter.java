package com.gorevev.testapplication.presentation.authentiacation;

import com.gorevev.testapplication.presentation.common.IBasePresenter;

/**
 * Created by e.gorev on 30.01.2017.
 */

public interface ILoginPresenter extends IBasePresenter<ILoginView, IAuthenticationRouter> {

    void login(String login, String password);

    void logout();
}
