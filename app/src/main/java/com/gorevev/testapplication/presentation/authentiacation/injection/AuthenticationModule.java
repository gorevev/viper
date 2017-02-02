package com.gorevev.testapplication.presentation.authentiacation.injection;

import android.content.Context;

import com.gorevev.testapplication.domain.user.LoginInteractor;
import com.gorevev.testapplication.domain.user.LogoutInteractor;
import com.gorevev.testapplication.presentation.authentiacation.AuthenticationRouter;
import com.gorevev.testapplication.presentation.authentiacation.IAuthenticationRouter;
import com.gorevev.testapplication.presentation.authentiacation.ILoginPresenter;
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
    IAuthenticationRouter providesRouter() {
        return new AuthenticationRouter(fragment.getActivity());
    }

    @Provides
    @ScreenScope
    ILoginPresenter providesPresenter(IAuthenticationRouter router,
                                      LoginInteractor loginInteractor,
                                      LogoutInteractor logoutInteractor) {

        return new LoginPresenter(router, loginInteractor, logoutInteractor);
    }
}
