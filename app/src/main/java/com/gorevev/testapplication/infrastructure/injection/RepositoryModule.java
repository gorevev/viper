package com.gorevev.testapplication.infrastructure.injection;

import android.content.Context;

import com.gorevev.testapplication.infrastructure.repository.GsonSerializer;
import com.gorevev.testapplication.infrastructure.repository.IRepository;
import com.gorevev.testapplication.infrastructure.repository.ISerializer;
import com.gorevev.testapplication.infrastructure.repository.SharedPreferencesRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ginko on 17.11.2016.
 */

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public ISerializer providesSerializer() {
        return new GsonSerializer();
    }

    @Provides
    @Singleton
    IRepository providesRepository(Context context, ISerializer serializer) {
        return new SharedPreferencesRepository(context, serializer);
    }
}
