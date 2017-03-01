package com.gorevev.testapplication.infrastructure.injection;

import com.gorevev.testapplication.presentation._common.injection.DomainModule;
import com.gorevev.testapplication.presentation.authentiacation.injection.AuthenticationComponent;
import com.gorevev.testapplication.presentation.authentiacation.injection.AuthenticationModule;
import com.gorevev.testapplication.presentation.main.injection.MainComponent;
import com.gorevev.testapplication.presentation.main.injection.MainModule;
import com.gorevev.testapplication.presentation.order_details.injection.OrderDetailsComponent;
import com.gorevev.testapplication.presentation.order_details.injection.OrderDetailsModule;
import com.gorevev.testapplication.presentation.splash.injection.SplashComponent;
import com.gorevev.testapplication.presentation.splash.injection.SplashModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ginko on 17.11.2016.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        RepositoryModule.class,
        NetworkModule.class,
        APIModule.class,
        NavigationModule.class,
        DomainModule.class
})
public interface AppComponent {

    SplashComponent plus(SplashModule module);

    AuthenticationComponent plus(AuthenticationModule module);

    MainComponent plus(MainModule mainModule);

    OrderDetailsComponent plus(OrderDetailsModule module);
}
