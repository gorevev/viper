package com.gorevev.testapplication.presentation.main.orders.injection;

import com.gorevev.testapplication.presentation._common.injection.ScreenScope;
import com.gorevev.testapplication.presentation.main.MainRouter;
import com.gorevev.testapplication.presentation.main.orders.IOrdersRouter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by e.gorev on 01.02.2017.
 */

@Module
public class OrdersModule {

    @Provides
    @ScreenScope
    public IOrdersRouter providesRouter(MainRouter router) {
        return router;
    }
}
