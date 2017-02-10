package com.gorevev.testapplication.presentation.authentiacation.injection;

import com.gorevev.testapplication.presentation.authentiacation.AuthenticationRouter;
import com.gorevev.testapplication.presentation.authentiacation.login.ILoginRouter;
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
    IStartPageRouter provideStartPageRouter(AuthenticationRouter router) {
        return router;
    }

    @Provides
    @ScreenScope
    ILoginRouter provideLoginRouter(AuthenticationRouter router) {
        return router;
    }
}
