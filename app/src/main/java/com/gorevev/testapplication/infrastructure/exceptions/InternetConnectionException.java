package com.gorevev.testapplication.infrastructure.exceptions;

/**
 * Created by denischuvasov on 20.02.17.
 */

public class InternetConnectionException extends Exception {
    public InternetConnectionException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return "Not internet connection";
    }
}
