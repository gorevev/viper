package com.gorevev.testapplication.presentation.main.injection;

import com.gorevev.testapplication.presentation._common.injection.ScreenScope;
import com.gorevev.testapplication.presentation.main.MainActivity;
import com.gorevev.testapplication.presentation.main.MainPresenter;

import dagger.Subcomponent;

/**
 * Created by denischuvasov on 10.02.17.
 */

@ScreenScope
@Subcomponent(modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity activity);

    MainPresenter mainPresenter();
}
