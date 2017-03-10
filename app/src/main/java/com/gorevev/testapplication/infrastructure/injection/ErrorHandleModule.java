package com.gorevev.testapplication.infrastructure.injection;

import com.gorevev.testapplication.infrastructure.exceptions.ErrorResolver;
import com.gorevev.testapplication.infrastructure.exceptions.error_handlers.*;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by e.gorev on 09.03.2017.
 */

@Module
public class ErrorHandleModule {

    @Provides
    public ErrorResolver providesErrorResolver(DefaultUnauthenticatedExceptionHandler unauthenticatedExceptionHandler,
                                               DefaultInternetConnectionExceptionHandler internetConnectionExceptionHandler) {
        return
                new ErrorResolver(
                internetConnectionExceptionHandler,
                unauthenticatedExceptionHandler);
    }
}
