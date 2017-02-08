package com.gorevev.testapplication.presentation.orders;

import com.gorevev.testapplication.presentation.common.IBasePresenter;

/**
 * Created by e.gorev on 01.02.2017.
 */

public interface IOrdersPresenter extends IBasePresenter<IOrdersView, IOrdersRouter> {

    void loadOrders();

    void refreshOrders();

    void onShowOrder(int id);
}
