package com.gorevev.testapplication.infrastructure.injection;

import com.gorevev.testapplication.infrastructure.network.HeadersInterceptor;
import com.gorevev.testapplication.infrastructure.headers.AuthorizationHeader;
import com.gorevev.testapplication.infrastructure.network.LoggingInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ginko on 04.12.2016.
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    HeadersInterceptor providesInterceptor(AuthorizationHeader authorizationHeader) {
        return new HeadersInterceptor(authorizationHeader);
    }

    @Provides
    @Singleton
    Converter.Factory providesConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    CallAdapter.Factory providesCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    @Singleton
    LoggingInterceptor providesLoggingInterceptor() {
        return new LoggingInterceptor();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(HeadersInterceptor interceptor,
                              Converter.Factory converterFactory,
                              CallAdapter.Factory callAdapterFactory,
                              LoggingInterceptor loggingInterceptor) {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addNetworkInterceptor(interceptor);
        httpClient.addInterceptor(loggingInterceptor);

        return new Retrofit.Builder()
                .baseUrl("http://develop.stand.dev.magdv.com/api/v1/")
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .client(httpClient.build())
                .build();
    }
}
