package com.gorevev.testapplication.presentation.splash;

import com.arellomobile.mvp.MvpView;

/**
 * Created by Ginko on 04.12.2016.
 */

public interface ISplashView extends MvpView {

    void finishInitialization();
    void showError(String message);
}
