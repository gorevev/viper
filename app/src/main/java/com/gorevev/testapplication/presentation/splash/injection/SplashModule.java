package com.gorevev.testapplication.presentation.splash.injection;

import com.gorevev.testapplication.presentation.common.BaseFragment;
import com.gorevev.testapplication.presentation.common.injection.ScreenScope;
import com.gorevev.testapplication.presentation.splash.ISplashRouter;
import com.gorevev.testapplication.presentation.splash.SplashPresenter;
import com.gorevev.testapplication.presentation.splash.SplashRouter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ginko on 07.12.2016.
 */

@Module
public class SplashModule {

    BaseFragment fragment;

    public SplashModule(BaseFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @ScreenScope
    ISplashRouter providesRouter() {
        return new SplashRouter(fragment.getActivity());
    }

    @Provides
    SplashPresenter providesPresenter(ISplashRouter router) {
        return new SplashPresenter(router);
    }
}
