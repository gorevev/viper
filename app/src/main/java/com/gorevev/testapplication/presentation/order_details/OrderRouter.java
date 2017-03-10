package com.gorevev.testapplication.presentation.order_details;

import com.gorevev.testapplication.presentation._common.BaseRouter;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

/**
 * Created by denischuvasov on 16.02.17.
 */

public class OrderRouter extends BaseRouter implements IOrderRouter {

    @Inject
    public OrderRouter(Router router) {
        super(router);
    }
}
