package com.gorevev.testapplication.presentation.splash;

import com.arellomobile.mvp.MvpView;
import com.gorevev.testapplication.presentation._common.IBaseView;

/**
 * Created by Ginko on 04.12.2016.
 */

public interface ISplashView extends IBaseView {

    void finishInitialization();
    void showError(String message);
}
