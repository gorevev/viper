package com.gorevev.testapplication.infrastructure.injection;

import com.gorevev.testapplication.domain.user.api.IUserAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Ginko on 06.12.2016.
 */

@Module
public class APIModule {

    @Provides
    @Singleton
    IUserAPI providesUserAPI(Retrofit retrofit) {
        return retrofit.create(IUserAPI.class);
    }
}
