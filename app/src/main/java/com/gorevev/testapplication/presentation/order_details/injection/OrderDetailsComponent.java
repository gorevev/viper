package com.gorevev.testapplication.presentation.order_details.injection;

import com.gorevev.testapplication.presentation._common.injection.ScreenScope;
import com.gorevev.testapplication.presentation.order_details.OrderDetailsActivity;
import com.gorevev.testapplication.presentation.order_details.OrderDetailsPresenter;

import dagger.Subcomponent;

/**
 * Created by denischuvasov on 16.02.17.
 */
@ScreenScope
@Subcomponent(modules = {OrderDetailsModule.class})
public interface OrderDetailsComponent {
    void inject(OrderDetailsActivity orderDetailsActivity);

    OrderDetailsPresenter orderDetailsPresenter();
}
