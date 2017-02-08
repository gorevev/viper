package com.gorevev.testapplication.presentation.authentiacation;

import com.arellomobile.mvp.MvpView;

/**
 * Created by e.gorev on 30.01.2017.
 */

public interface ILoginView extends MvpView {

    void showProgress();

    void hideProgress();

    void loggedIn();

    void loggedOut();

    void showError(String message);
}
