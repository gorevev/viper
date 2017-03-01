package com.gorevev.testapplication.presentation.authentiacation.injection;

import com.gorevev.testapplication.presentation.authentiacation.AuthenticationRouter;
import com.gorevev.testapplication.presentation.authentiacation.confirm_sms.IConfirmSMSRouter;
import com.gorevev.testapplication.presentation.authentiacation.login.ILoginRouter;
import com.gorevev.testapplication.presentation.authentiacation.registration.IRegistrationRouter;
import com.gorevev.testapplication.presentation.authentiacation.startpage.IStartPageRouter;
import com.gorevev.testapplication.presentation._common.injection.ScreenScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by e.gorev on 30.01.2017.
 */

@Module
public class AuthenticationModule {

    @Provides
    @ScreenScope
    IStartPageRouter providesStartPageRouter(AuthenticationRouter router) {
        return router;
    }

    @Provides
    @ScreenScope
    ILoginRouter providesLoginRouter(AuthenticationRouter router) {
        return router;
    }

    @Provides
    @ScreenScope
    IRegistrationRouter providesRegistrationRouter(AuthenticationRouter router) {
        return router;
    }

    @Provides
    @ScreenScope
    IConfirmSMSRouter providesConfirmSMSRouter(AuthenticationRouter router) {
        return router;
    }
}
