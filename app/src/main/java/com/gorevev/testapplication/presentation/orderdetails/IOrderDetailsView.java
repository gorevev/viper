package com.gorevev.testapplication.presentation.orderdetails;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.gorevev.testapplication.domain.order.entities.OrderContainer;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface IOrderDetailsView extends MvpView {
    void showError(String message);
    void showOrder(OrderContainer orderContainer);
    void showProgress();
    void hideProgress();
}
