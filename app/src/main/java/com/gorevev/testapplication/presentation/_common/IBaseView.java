package com.gorevev.testapplication.presentation._common;

import com.arellomobile.mvp.MvpView;

/**
 * Created by denischuvasov on 21.02.17.
 */

public interface IBaseView extends MvpView {
    void showError(Throwable throwable);
}
