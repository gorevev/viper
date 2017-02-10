package com.gorevev.testapplication.presentation.main.orders;

/**
 * Created by e.gorev on 01.02.2017.
 */

public interface IOrdersPresenter {

    void loadOrders();

    void refreshOrders();

    void onShowOrder(int id);
}
