package com.gorevev.testapplication.presentation.order_details.injection;

import com.gorevev.testapplication.presentation._common.injection.ScreenScope;
import com.gorevev.testapplication.presentation.order_details.IOrderRouter;
import com.gorevev.testapplication.presentation.order_details.OrderRouter;

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
