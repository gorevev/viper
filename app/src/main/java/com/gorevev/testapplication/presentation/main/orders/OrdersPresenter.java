package com.gorevev.testapplication.presentation.main.orders;

import com.arellomobile.mvp.InjectViewState;
import com.gorevev.testapplication.domain.order.GetOrdersInteractor;
import com.gorevev.testapplication.domain.order.entities.OrdersList;
import com.gorevev.testapplication.presentation._common.BasePresenter;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by e.gorev on 01.02.2017.
 */

@InjectViewState
public class OrdersPresenter extends BasePresenter<IOrdersView, IOrdersRouter> implements IOrdersPresenter {

    GetOrdersInteractor getOrdersInteractor;

    OrdersList orders = new OrdersList();

    int page = 0;

    @Inject
    public OrdersPresenter(IOrdersRouter router, GetOrdersInteractor getOrdersInteractor) {
        this.setRouter(router);
        this.getOrdersInteractor = getOrdersInteractor;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadOrders();
    }

    @Override
    public void loadOrders() {

        Map<String, String> parameters = new HashMap<>();
        parameters.put("page", String.valueOf(page + 1));

        getOrdersInteractor.execute(parameters).subscribe(
                response -> {

                    page++;

                    orders.addOrders(response.getData());
                    orders.setTotal(response.getData().getTotal());

                    getViewState().setOrders(orders.getOrders(), orders.mayBeMore());
                },
                throwable -> {
                    getViewState().showError(throwable.getMessage());
                }
        );
    }

    @Override
    public void refreshOrders() {

        page = 0;
        orders.getOrders().clear();
        loadOrders();
    }

    @Override
    public void onShowOrder(int id) {
        getRouter().showOrderDetails(id);
    }
}
