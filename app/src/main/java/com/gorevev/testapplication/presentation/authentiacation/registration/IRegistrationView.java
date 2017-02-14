package com.gorevev.testapplication.presentation.authentiacation.registration;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by denischuvasov on 13.02.17.
 */
public interface IRegistrationView extends MvpView {
    void showError(Throwable throwable);
    void showProgress();
    void hideProgress();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showConfirmDialog();
}
