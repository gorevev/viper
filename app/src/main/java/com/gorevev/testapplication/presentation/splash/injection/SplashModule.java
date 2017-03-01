package com.gorevev.testapplication.presentation.splash.injection;

import com.gorevev.testapplication.presentation._common.injection.ScreenScope;
import com.gorevev.testapplication.presentation.splash.ISplashRouter;
import com.gorevev.testapplication.presentation.splash.SplashRouter;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Router;

/**
 * Created by Ginko on 07.12.2016.
 */

@Module
public class SplashModule {

    @Provides
    @ScreenScope
    ISplashRouter providesRouter(Router router) {
        return new SplashRouter(router);
    }
}
