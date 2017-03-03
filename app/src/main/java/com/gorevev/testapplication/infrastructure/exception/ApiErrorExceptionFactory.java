package com.gorevev.testapplication.infrastructure.exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.gorevev.testapplication.domain._common.entities.ErrorResponse;

import java.io.IOException;
import java.nio.charset.Charset;

import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by denischuvasov on 20.02.17.
 */

public final class ApiErrorExceptionFactory {

    private ApiErrorExceptionFactory() {
    }

    public static Throwable fromHttpException(final HttpException httpException) {
        try {
            switch (httpException.code()) {
                case 400: {
                    final String jsonString = new String(httpException.response().errorBody().bytes(),
                            Charset.defaultCharset());
                    final Gson gson = new GsonBuilder().create();
                    final ErrorResponse errorResponse = gson.fromJson(jsonString, ErrorResponse.class);
                    return new ApiErrorException(httpException.code(), errorResponse, httpException);
                }
                case 401:
                    return new UnauthenticatedException(httpException);
                case 404:
                    return new NotFoundException(httpException);
                case 426:
                    return new UpgradeRequiredException(httpException);
                default:
                    return new UncheckedException(httpException);
            }

        } catch (JsonSyntaxException | NullPointerException | IOException e) {
            return new ApiErrorException(httpException.code(), null, "network error ", httpException);
        }
    }
}
