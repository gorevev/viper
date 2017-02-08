package com.gorevev.testapplication.presentation.orders;

import com.arellomobile.mvp.MvpView;

import com.gorevev.testapplication.domain.order.entities.Order;

import java.util.List;

/**
 * Created by e.gorev on 01.02.2017.
 */

public interface IOrdersView extends MvpView {

    void showError(String message);

    void addOrders(List<Order> orders, boolean mayBeMore);

    void setOrders(List<Order> orders, boolean mayBeMore);
}
