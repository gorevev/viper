package com.gorevev.testapplication.presentation.authentiacation.registration;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.gorevev.testapplication.presentation._common.IBaseView;

/**
 * Created by denischuvasov on 13.02.17.
 */
public interface IRegistrationView extends IBaseView {
    void showProgress();
    void hideProgress();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showConfirmDialog();
}
