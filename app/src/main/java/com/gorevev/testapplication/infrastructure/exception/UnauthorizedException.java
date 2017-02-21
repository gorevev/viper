package com.gorevev.testapplication.infrastructure.exception;

/**
 * Created by denischuvasov on 20.02.17.
 */

public class UnauthorizedException extends Exception {
    public UnauthorizedException(Throwable cause) {
        super(cause);
    }
}
