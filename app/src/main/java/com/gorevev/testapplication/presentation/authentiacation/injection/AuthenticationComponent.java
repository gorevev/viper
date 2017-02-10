package com.gorevev.testapplication.presentation.authentiacation.injection;

import com.gorevev.testapplication.presentation._common.injection.DomainModule;
import com.gorevev.testapplication.presentation._common.injection.ScreenScope;
import com.gorevev.testapplication.presentation.authentiacation.AuthenticationActivity;
import com.gorevev.testapplication.presentation.authentiacation.login.LoginPresenter;
import com.gorevev.testapplication.presentation.authentiacation.startpage.StartPagePresenter;

import dagger.Subcomponent;

/**
 * Created by e.gorev on 30.01.2017.
 */

@ScreenScope
@Subcomponent(modules = {AuthenticationModule.class, DomainModule.class})
public interface AuthenticationComponent {

    LoginPresenter loginPresenter();
    StartPagePresenter startPagePresenter();

    void inject(AuthenticationActivity authenticationActivity);
}
