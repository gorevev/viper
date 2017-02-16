package com.gorevev.testapplication.presentation.main.orders.injection;

import com.gorevev.testapplication.presentation._common.injection.ScreenScope;
import com.gorevev.testapplication.presentation.main.orders.OrdersFragment;
import com.gorevev.testapplication.presentation.main.orders.OrdersPresenter;

import dagger.Subcomponent;

/**
 * Created by e.gorev on 01.02.2017.
 */

@ScreenScope
@Subcomponent(modules = {OrdersModule.class})
public interface OrdersComponent {

    void inject(OrdersFragment fragment);

    OrdersPresenter ordersPresenter();
}
