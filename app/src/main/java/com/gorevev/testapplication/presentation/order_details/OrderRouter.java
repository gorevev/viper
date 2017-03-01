package com.gorevev.testapplication.presentation.order_details;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

/**
 * Created by denischuvasov on 16.02.17.
 */

public class OrderRouter implements IOrderRouter {

    private Router router;

    @Inject
    public OrderRouter(Router router) {

        this.router = router;
    }

    @Override
    public void back() {
        router.exit();
    }
}
