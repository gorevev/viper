package com.gorevev.testapplication.infrastructure.exceptions.error_handlers;

import com.gorevev.testapplication.infrastructure.exceptions.IExceptionHandler;
import com.gorevev.testapplication.infrastructure.exceptions.UnauthenticatedException;
import com.gorevev.testapplication.presentation._common.IBaseRouter;
import com.gorevev.testapplication.presentation._common.IBaseView;

import javax.inject.Inject;

/**
 * Created by e.gorev on 09.03.2017.
 */

public class DefaultUnauthenticatedExceptionHandler implements IExceptionHandler<IBaseView, IBaseRouter> {

    @Inject
    public DefaultUnauthenticatedExceptionHandler() {

    }

    @Override
    public boolean handleError(Throwable throwable, IBaseView view, IBaseRouter router) {

        if (throwable instanceof UnauthenticatedException) {
            router.showLogin();

            return true;
        }

        return false;
    }

    @Override
    public String getProcessedErrorKey() {
        return UnauthenticatedException.class.getSimpleName();
    }
}
