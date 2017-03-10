package com.gorevev.testapplication.presentation._common;

import android.support.annotation.StringRes;

import com.arellomobile.mvp.MvpView;

/**
 * Created by denischuvasov on 21.02.17.
 */

public interface IBaseView extends MvpView {
    void showSnackbar(Throwable throwable);

    void showSnackbar(@StringRes int id);
}
