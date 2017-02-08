package com.gorevev.testapplication.infrastructure;

import android.app.Application;

import com.gorevev.testapplication.presentation.authentiacation.LoginFragment;
import com.gorevev.testapplication.presentation.authentiacation.injection.AuthenticationComponent;
import com.gorevev.testapplication.presentation.authentiacation.injection.AuthenticationModule;
import com.gorevev.testapplication.presentation.orders.OrdersFragment;
import com.gorevev.testapplication.presentation.orders.injection.OrdersComponent;
import com.gorevev.testapplication.presentation.orders.injection.OrdersModule;
import com.gorevev.testapplication.presentation.splash.SplashFragment;
import com.gorevev.testapplication.presentation.splash.injection.SplashComponent;
import com.gorevev.testapplication.presentation.splash.injection.SplashModule;
import com.gorevev.testapplication.infrastructure.injection.AppComponent;
import com.gorevev.testapplication.infrastructure.injection.AppModule;
import com.gorevev.testapplication.infrastructure.injection.DaggerAppComponent;

/**
 * Created by Ginko on 03.12.2016.
 */

public class App extends Application {

    private static App instance;

    private AppComponent appComponent;
    private SplashComponent splashComponent;
    private AuthenticationComponent authenticationComponent;
    private OrdersComponent ordersComponent;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        appComponent = DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .build();
    }

    public SplashComponent getSplashComponent(SplashFragment fragment) {

        if (splashComponent == null)
            splashComponent = appComponent.plus(new SplashModule(fragment));

        splashComponent.inject(fragment);

        return splashComponent;
    }

    public AuthenticationComponent getAuthenticationComponent(LoginFragment fragment) {

        if (authenticationComponent == null)
            authenticationComponent = appComponent.plus(new AuthenticationModule(fragment));

        authenticationComponent.inject(fragment);

        return authenticationComponent;
    }

    public OrdersComponent getOrdersComponent(OrdersFragment fragment) {

        if (ordersComponent == null)
            ordersComponent = appComponent.plus(new OrdersModule(fragment));

        ordersComponent.inject(fragment);

        return ordersComponent;
    }

    public void releaseSplashComponent() {
        splashComponent = null;
    }

    public void releaseAuthenticationComponent() {
        authenticationComponent = null;
    }

    public void releaseRoutesListComponent() {
        ordersComponent = null;
    }
}
