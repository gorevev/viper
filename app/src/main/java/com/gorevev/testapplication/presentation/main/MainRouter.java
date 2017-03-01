package com.gorevev.testapplication.presentation.main;

import com.gorevev.testapplication.presentation.main.orders.IOrdersRouter;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

/**
 * Created by denischuvasov on 10.02.17.
 */

public class MainRouter implements IOrdersRouter, IMainRouter {

    Router router;

    @Inject
    public MainRouter(Router router) {
        this.router = router;
    }

    @Override
    public void showOrderDetails(int id) {
        router.navigateTo(MainTransitions.ORDER_DETAILS_SCREEN, id);
    }

    @Override
    public void back() {
        router.exit();
    }

    @Override
    public void showOrders() {
        router.replaceScreen(MainTransitions.ORDERS);
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
        router.replaceScreen(MainTransitions.AUTHENTICATION_SCREEN);
    }
}
