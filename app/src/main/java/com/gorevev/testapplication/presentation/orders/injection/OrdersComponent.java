package com.gorevev.testapplication.presentation.orders.injection;

import com.gorevev.testapplication.presentation.common.injection.ScreenScope;
import com.gorevev.testapplication.presentation.orders.OrdersFragment;

import dagger.Subcomponent;

/**
 * Created by e.gorev on 01.02.2017.
 */

@ScreenScope
@Subcomponent(modules = {OrdersModule.class})
public interface OrdersComponent {

    void inject(OrdersFragment fragment);
}
