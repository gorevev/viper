package com.gorevev.testapplication.infrastructure.exceptions.error_handlers;

import com.gorevev.testapplication.infrastructure.exceptions.IExceptionHandler;
import com.gorevev.testapplication.infrastructure.exceptions.InternetConnectionException;
import com.gorevev.testapplication.presentation._common.IBaseRouter;
import com.gorevev.testapplication.presentation._common.IBaseView;

import javax.inject.Inject;

/**
 * Created by e.gorev on 10.03.2017.
 */

public class DefaultInternetConnectionExceptionHandler implements IExceptionHandler<IBaseView, IBaseRouter> {

    @Inject
    public DefaultInternetConnectionExceptionHandler() {

    }

    @Override
    public boolean handleError(Throwable throwable, IBaseView view, IBaseRouter router) {

        if (throwable instanceof InternetConnectionException) {
            view.showSnackbar(throwable);

            return true;
        }
        return false;
    }

    @Override
    public String getProcessedErrorKey() {
        return InternetConnectionException.class.getSimpleName();
    }
}
