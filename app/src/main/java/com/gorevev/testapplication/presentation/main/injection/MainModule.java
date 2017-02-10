package com.gorevev.testapplication.presentation.main.injection;

import com.gorevev.testapplication.presentation.main.IMainRouter;
import com.gorevev.testapplication.presentation.main.MainRouter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by denischuvasov on 10.02.17.
 */

@Module
public class MainModule {

    @Provides
    IMainRouter provideMainRouter(MainRouter router) {
        return router;
    }
}
