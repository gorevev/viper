package com.gorevev.testapplication.infrastructure;

import android.app.Application;

import com.gorevev.testapplication.infrastructure.injection.AppComponent;
import com.gorevev.testapplication.infrastructure.injection.AppModule;
import com.gorevev.testapplication.infrastructure.injection.DaggerAppComponent;
import com.gorevev.testapplication.presentation.authentiacation.injection.AuthenticationComponent;
import com.gorevev.testapplication.presentation.authentiacation.injection.AuthenticationModule;
import com.gorevev.testapplication.presentation.main.injection.MainComponent;
import com.gorevev.testapplication.presentation.main.injection.MainModule;
import com.gorevev.testapplication.presentation.order_details.injection.OrderDetailsComponent;
import com.gorevev.testapplication.presentation.order_details.injection.OrderDetailsModule;
import com.gorevev.testapplication.presentation.splash.injection.SplashComponent;
import com.gorevev.testapplication.presentation.splash.injection.SplashModule;

/**
 * Created by Ginko on 03.12.2016.
 */

public class App extends Application {

    private static App instance;

    private AppComponent appComponent;
    private SplashComponent splashComponent;
    private AuthenticationComponent authenticationComponent;
    private OrderDetailsComponent orderDetailsComponent;
    private MainComponent mainComponent;

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

    public SplashComponent getSplashComponent() {

        if (splashComponent == null)
            splashComponent = appComponent.plus(new SplashModule());

        return splashComponent;
    }

    public AuthenticationComponent getAuthenticationComponent() {

        if (authenticationComponent == null)
            authenticationComponent = appComponent.plus(new AuthenticationModule());

        return authenticationComponent;
    }

    public MainComponent getMainComponent() {
        if(mainComponent == null) {
            mainComponent = appComponent.plus(new MainModule());
        }

        return mainComponent;
    }

    public OrderDetailsComponent getOrderDetailsComponent() {
        if (orderDetailsComponent == null) {
            orderDetailsComponent = appComponent.plus(new OrderDetailsModule());
        }

        return orderDetailsComponent;
    }

    public void releaseSplashComponent() {
        splashComponent = null;
    }

    public void releaseAuthenticationComponent() {
        authenticationComponent = null;
    }

    public void releaseMainComponent() {
        mainComponent = null;
    }

    public void releaseOrderDelailsComponent() {
        orderDetailsComponent = null;
    }
}
