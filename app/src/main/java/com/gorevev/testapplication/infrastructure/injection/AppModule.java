package com.gorevev.testapplication.infrastructure.injection;

import android.app.Application;
import android.content.Context;

import com.gorevev.testapplication.infrastructure.CurrentActivityProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ginko on 17.11.2016.
 */

@Module
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context providesContext() {
        return application;
    }

    @Provides
    @Singleton
    public CurrentActivityProvider providesCurrentActivityProvider() {
        return new CurrentActivityProvider(application);
    }
}
