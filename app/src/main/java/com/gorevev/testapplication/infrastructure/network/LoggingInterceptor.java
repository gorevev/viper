package com.gorevev.testapplication.infrastructure.network;

import com.gorevev.testapplication.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by denischuvasov on 14.02.17.
 */

public class LoggingInterceptor implements Interceptor {
    private final Interceptor interceptor;

    public LoggingInterceptor() {
        interceptor = new HttpLoggingInterceptor().
                setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return interceptor.intercept(chain);
    }
}
