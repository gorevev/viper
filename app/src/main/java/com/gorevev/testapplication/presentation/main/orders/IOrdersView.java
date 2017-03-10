package com.gorevev.testapplication.presentation.main.orders;

import com.arellomobile.mvp.MvpView;

import com.gorevev.testapplication.domain.order.entities.Order;
import com.gorevev.testapplication.presentation._common.IBaseView;

import java.util.List;

/**
 * Created by e.gorev on 01.02.2017.
 */

public interface IOrdersView extends IBaseView {

    void showError(String message);

    void addOrders(List<Order> orders, boolean mayBeMore);

    void setOrders(List<Order> orders, boolean mayBeMore);
}
