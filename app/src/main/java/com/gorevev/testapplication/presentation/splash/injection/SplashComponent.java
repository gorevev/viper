package com.gorevev.testapplication.presentation.splash.injection;

import com.gorevev.testapplication.presentation._common.injection.ScreenScope;
import com.gorevev.testapplication.presentation.splash.SplashActivity;
import com.gorevev.testapplication.presentation.splash.SplashPresenter;

import dagger.Subcomponent;

/**
 * Created by Ginko on 07.12.2016.
 */

@ScreenScope
@Subcomponent(modules = {SplashModule.class})
public interface SplashComponent {

    SplashPresenter splashPresenter();

    void inject(SplashActivity activity);
}
