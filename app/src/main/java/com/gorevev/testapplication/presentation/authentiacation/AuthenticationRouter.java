package com.gorevev.testapplication.presentation.authentiacation;

import com.gorevev.testapplication.presentation.authentiacation.login.ILoginRouter;
import com.gorevev.testapplication.presentation.authentiacation.startpage.IStartPageRouter;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

/**
 * Created by e.gorev on 30.01.2017.
 */

public class AuthenticationRouter implements IStartPageRouter, ILoginRouter {

    Router router;

    @Inject
    public AuthenticationRouter(Router router) {
        this.router = router;
    }

    @Override
    public void showLogin() {
        router.navigateTo(AuthTransitions.LOGIN);
    }

    @Override
    public void showRegistration() {
        router.navigateTo(AuthTransitions.REGISTRATION);
    }

    @Override
    public void showPasswordRecovery() {
        router.navigateTo(AuthTransitions.PASSWORD_RECOVERY);
    }

    @Override
    public void showMainScreen() {
        router.replaceScreen(AuthTransitions.MAIN_SCREEN);
    }

    @Override
    public void back() {
        router.exit();
    }
}
