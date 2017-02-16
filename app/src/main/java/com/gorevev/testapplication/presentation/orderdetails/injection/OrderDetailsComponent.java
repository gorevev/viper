package com.gorevev.testapplication.presentation.orderdetails.injection;

import com.gorevev.testapplication.presentation._common.injection.ScreenScope;
import com.gorevev.testapplication.presentation.orderdetails.OrderDetailsActivity;
import com.gorevev.testapplication.presentation.orderdetails.OrderDetailsPresenter;

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
