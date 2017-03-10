package com.gorevev.testapplication.presentation.authentiacation.login;

import com.arellomobile.mvp.MvpView;
import com.gorevev.testapplication.presentation._common.IBaseView;

/**
 * Created by e.gorev on 30.01.2017.
 */

public interface ILoginView extends IBaseView {

    void showProgress();

    void hideProgress();

    void loggedIn();
}
