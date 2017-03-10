package com.gorevev.testapplication.presentation.authentiacation;

import com.gorevev.testapplication.presentation._common.BaseRouter;
import com.gorevev.testapplication.presentation.authentiacation.confirm_sms.IConfirmSMSRouter;
import com.gorevev.testapplication.presentation.authentiacation.login.ILoginRouter;
import com.gorevev.testapplication.presentation.authentiacation.registration.IRegistrationRouter;
import com.gorevev.testapplication.presentation.authentiacation.startpage.IStartPageRouter;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

/**
 * Created by e.gorev on 30.01.2017.
 */

public class AuthenticationRouter extends BaseRouter implements IStartPageRouter, ILoginRouter, IRegistrationRouter, IConfirmSMSRouter {

    @Inject
    public AuthenticationRouter(Router router) {
        super(router);
    }

    @Override
    public void showLogin() {
        getRouter().navigateTo(AuthTransitions.LOGIN);
    }

    @Override
    public void showRegistration() {
        getRouter().navigateTo(AuthTransitions.REGISTRATION);
    }

    @Override
    public void showMainScreen() {
        getRouter().replaceScreen(AuthTransitions.MAIN_SCREEN);
    }

    @Override
    public void showConfirmSmsDialog() {
        getRouter().navigateTo(AuthTransitions.SMS_CONFIRM);
    }
}
