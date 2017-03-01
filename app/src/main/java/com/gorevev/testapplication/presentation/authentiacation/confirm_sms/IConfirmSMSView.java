package com.gorevev.testapplication.presentation.authentiacation.confirm_sms;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by denischuvasov on 14.02.17.
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface IConfirmSMSView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showError(Throwable throwable);

    void showRemainingTime(int seconds);

    void showResendButton();
}
