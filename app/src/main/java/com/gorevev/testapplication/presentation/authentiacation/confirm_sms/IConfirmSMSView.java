package com.gorevev.testapplication.presentation.authentiacation.confirm_sms;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.gorevev.testapplication.presentation._common.IBaseView;

/**
 * Created by denischuvasov on 14.02.17.
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface IConfirmSMSView extends IBaseView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showSnackbar(Throwable throwable);

    void showRemainingTime(int seconds);

    void showResendButton();
}
