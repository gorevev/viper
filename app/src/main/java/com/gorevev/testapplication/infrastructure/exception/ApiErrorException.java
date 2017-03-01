package com.gorevev.testapplication.infrastructure.exception;

import com.gorevev.testapplication.domain._common.entities.ErrorResponse;

/**
 * Created by denischuvasov on 20.02.17.
 */

public class ApiErrorException extends RuntimeException {
    private final ErrorResponse errors;
    private final int httpCode;

    public ApiErrorException(int httpCode, ErrorResponse errors, Throwable throwable) {
        this(httpCode, errors, errors.getMessage(), throwable);
    }

    public ApiErrorException(int httpCode, ErrorResponse errors, String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
        this.errors = errors;
        this.httpCode = httpCode;
    }
}
