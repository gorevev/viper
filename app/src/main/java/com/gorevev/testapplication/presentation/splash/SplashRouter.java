package com.gorevev.testapplication.presentation.splash;

import com.gorevev.testapplication.presentation._common.BaseRouter;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

/**
 * Created by Ginko on 07.12.2016.
 */

public class SplashRouter extends BaseRouter implements ISplashRouter {

    @Inject
    public SplashRouter(Router router) {
        super(router);
    }

    @Override
    public void showAuthentication() {

        getRouter().replaceScreen(SplashTransitions.AUTHENTICATION);
    }

    @Override
    public void showMainScreen() {

        getRouter().replaceScreen(SplashTransitions.MAIN_SCREEN);
    }
}
