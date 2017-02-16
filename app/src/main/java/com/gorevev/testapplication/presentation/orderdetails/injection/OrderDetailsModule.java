package com.gorevev.testapplication.presentation.orderdetails.injection;

import com.gorevev.testapplication.presentation._common.injection.ScreenScope;
import com.gorevev.testapplication.presentation.orderdetails.IOrderRouter;
import com.gorevev.testapplication.presentation.orderdetails.OrderRouter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by denischuvasov on 16.02.17.
 */

@Module
public class OrderDetailsModule {

    @Provides
    @ScreenScope
    IOrderRouter providesOrderRouter(OrderRouter router) {
        return router;
    }
}
