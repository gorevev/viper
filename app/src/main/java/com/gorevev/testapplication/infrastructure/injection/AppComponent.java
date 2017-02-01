package com.gorevev.testapplication.infrastructure.injection;

import com.gorevev.testapplication.presentation.authentiacation.injection.AuthenticationComponent;
import com.gorevev.testapplication.presentation.authentiacation.injection.AuthenticationModule;
import com.gorevev.testapplication.presentation.routes.injection.RoutesListComponent;
import com.gorevev.testapplication.presentation.routes.injection.RoutesListModule;
import com.gorevev.testapplication.presentation.splash.injection.SplashComponent;
import com.gorevev.testapplication.presentation.splash.injection.SplashModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ginko on 17.11.2016.
 */

@Singleton
@Component(modules = {AppModule.class, RepositoryModule.class, NetworkModule.class, APIModule.class})
public interface AppComponent {

    SplashComponent plus(SplashModule module);
    AuthenticationComponent plus(AuthenticationModule module);
    RoutesListComponent plus(RoutesListModule module);
}
