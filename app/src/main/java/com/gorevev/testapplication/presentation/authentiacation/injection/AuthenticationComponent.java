package com.gorevev.testapplication.presentation.authentiacation.injection;

import com.gorevev.testapplication.presentation.authentiacation.LoginFragment;
import com.gorevev.testapplication.presentation.common.injection.DomainModule;
import com.gorevev.testapplication.presentation.common.injection.ScreenScope;

import dagger.Subcomponent;

/**
 * Created by e.gorev on 30.01.2017.
 */

@ScreenScope
@Subcomponent(modules = {AuthenticationModule.class, DomainModule.class})
public interface AuthenticationComponent {

    void inject(LoginFragment view);
}
