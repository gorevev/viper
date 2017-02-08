package com.gorevev.testapplication.presentation.orders;

import com.gorevev.testapplication.domain.order.GetOrdersInteractor;
import com.gorevev.testapplication.domain.order.entities.OrdersList;
import com.gorevev.testapplication.presentation.common.BasePresenter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by e.gorev on 01.02.2017.
 */

public class OrdersPresenter extends BasePresenter<IOrdersView, IOrdersRouter> implements IOrdersPresenter {

    GetOrdersInteractor getOrdersInteractor;

    OrdersList orders = new OrdersList();

    int page = 0;

    public OrdersPresenter(IOrdersRouter router, GetOrdersInteractor getOrdersInteractor) {
        this.setRouter(router);
        this.getOrdersInteractor = getOrdersInteractor;
    }

    @Override
    public void onStart() {
        if (page == 0)
            loadOrders();
        else
            getView().setOrders(orders.getOrders(), orders.mayBeMore());
    }

    @Override
    public void onStop() {

    }

    @Override
    public void loadOrders() {

        if (!getOrdersInteractor.isWorking()) {

            Map<String, String> parameters = new HashMap<>();
            parameters.put("page", String.valueOf(page + 1));

            getOrdersInteractor.execute(parameters).subscribe(
                    response -> {

                        page++;
                        getOrdersInteractor.release();

                        orders.addOrders(response.getData());
                        orders.setTotal(response.getData().getTotal());

                        if (getView() != null)
                            getView().setOrders(orders.getOrders(), orders.mayBeMore());
                    },
                    throwable -> {
                        getOrdersInteractor.release();
                        getView().showError(throwable.getMessage());
                    }
            );
        }
    }

    @Override
    public void refreshOrders() {

        page = 0;
        orders.getOrders().clear();
        loadOrders();
    }

    @Override
    public void onShowOrder(int id) {
        getRouter().onShowOrder(id);
    }
}
