package com.gorevev.testapplication.presentation.main;

import com.gorevev.testapplication.presentation._common.BaseRouter;
import com.gorevev.testapplication.presentation.authentiacation.AuthTransitions;
import com.gorevev.testapplication.presentation.main.orders.IOrdersRouter;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

/**
 * Created by denischuvasov on 10.02.17.
 */

public class MainRouter extends BaseRouter implements IOrdersRouter, IMainRouter {

    @Inject
    public MainRouter(Router router) {
        super(router);
    }

    @Override
    public void showOrderDetails(int id) {
        getRouter().navigateTo(MainTransitions.ORDER_DETAILS_SCREEN, id);
    }

    @Override
    public void showOrders() {
        getRouter().replaceScreen(MainTransitions.ORDERS);
    }

    @Override
    public void showFavoritesOrders() {
        //TODO show favorites orders
    }

    @Override
    public void showSearchOrders() {
        //TODO show search orders
    }

    @Override
    public void showAuthentication() {
        getRouter().replaceScreen(MainTransitions.AUTHENTICATION_SCREEN);
    }
}
