package com.gorevev.testapplication.presentation.authentiacation.login;

import com.arellomobile.mvp.MvpView;

/**
 * Created by e.gorev on 30.01.2017.
 */

public interface ILoginView extends MvpView {

    void showProgress();

    void hideProgress();

    void loggedIn();

    void showError(String message);
}
