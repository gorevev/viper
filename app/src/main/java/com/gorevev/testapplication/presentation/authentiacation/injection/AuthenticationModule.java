package com.gorevev.testapplication.presentation.authentiacation.injection;

import com.gorevev.testapplication.domain.user.LoginInteractor;
import com.gorevev.testapplication.domain.user.LogoutInteractor;
import com.gorevev.testapplication.infrastructure.CurrentActivityProvider;
import com.gorevev.testapplication.presentation.authentiacation.AuthenticationRouter;
import com.gorevev.testapplication.presentation.authentiacation.IAuthenticationRouter;
import com.gorevev.testapplication.presentation.authentiacation.LoginPresenter;
import com.gorevev.testapplication.presentation.common.BaseFragment;
import com.gorevev.testapplication.presentation.common.injection.ScreenScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by e.gorev on 30.01.2017.
 */

@Module
public class AuthenticationModule {

    BaseFragment fragment;

    public AuthenticationModule(BaseFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @ScreenScope
    IAuthenticationRouter providesRouter(CurrentActivityProvider provider) {
        return new AuthenticationRouter(provider);
    }

    @Provides
    @ScreenScope
    LoginPresenter providesPresenter(IAuthenticationRouter router,
                                      LoginInteractor loginInteractor,
                                      LogoutInteractor logoutInteractor) {

        return new LoginPresenter(router, loginInteractor, logoutInteractor);
    }
}
