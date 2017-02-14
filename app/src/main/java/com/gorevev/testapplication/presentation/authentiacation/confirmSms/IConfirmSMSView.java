package com.gorevev.testapplication.presentation.authentiacation.confirmSms;

import com.arellomobile.mvp.MvpView;

/**
 * Created by denischuvasov on 14.02.17.
 */
public interface IConfirmSMSView extends MvpView {
    void showError(Throwable throwable);
}
