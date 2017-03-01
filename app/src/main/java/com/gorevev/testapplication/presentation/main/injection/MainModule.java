package com.gorevev.testapplication.presentation.main.injection;

import com.gorevev.testapplication.presentation._common.injection.ScreenScope;
import com.gorevev.testapplication.presentation.main.IMainRouter;
import com.gorevev.testapplication.presentation.main.MainRouter;
import com.gorevev.testapplication.presentation.main.orders.IOrdersRouter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by denischuvasov on 10.02.17.
 */

@Module
public class MainModule {

    @Provides
    IMainRouter providesMainRouter(MainRouter router) {
        return router;
    }

    @Provides
    @ScreenScope
    public IOrdersRouter providesOrdersRouter(MainRouter router) {
        return router;
    }
}
