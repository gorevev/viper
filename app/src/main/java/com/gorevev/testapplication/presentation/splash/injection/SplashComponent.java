package com.gorevev.testapplication.presentation.splash.injection;

import com.gorevev.testapplication.presentation.common.injection.ScreenScope;
import com.gorevev.testapplication.presentation.splash.SplashFragment;

import dagger.Subcomponent;

/**
 * Created by Ginko on 07.12.2016.
 */

@ScreenScope
@Subcomponent(modules = {SplashModule.class})
public interface SplashComponent {

    void inject(SplashFragment view);
}
