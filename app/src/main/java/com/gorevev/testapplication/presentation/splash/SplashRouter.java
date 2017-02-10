package com.gorevev.testapplication.presentation.splash;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

/**
 * Created by Ginko on 07.12.2016.
 */

public class SplashRouter implements ISplashRouter {

    private Router router;

    @Inject
    public SplashRouter(Router router) {

        this.router = router;
    }

    @Override
    public void showAuthentication() {

        router.replaceScreen(SplashTransitions.AUTHENTICATION);
    }

    @Override
    public void showMainScreen() {

        router.replaceScreen(SplashTransitions.MAIN_SCREEN);
    }

    @Override
    public void back() {

        router.exit();
    }
}
