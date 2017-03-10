package com.gorevev.testapplication.presentation.authentiacation.login.error_handlers;

import com.gorevev.testapplication.R;
import com.gorevev.testapplication.infrastructure.exceptions.IExceptionHandler;
import com.gorevev.testapplication.infrastructure.exceptions.UnauthenticatedException;
import com.gorevev.testapplication.presentation.authentiacation.login.ILoginRouter;
import com.gorevev.testapplication.presentation.authentiacation.login.ILoginView;

/**
 * Created by e.gorev on 09.03.2017.
 */

public class LoginUnauthenticatedExceptionHandler implements IExceptionHandler<ILoginView, ILoginRouter> {

    @Override
    public boolean handleError(Throwable throwable, ILoginView view, ILoginRouter router) {

        if (throwable instanceof UnauthenticatedException) {
            view.showSnackbar(R.string.login_unauthenticated_exception);

            return true;
        }

        return false;
    }

    @Override
    public String getProcessedErrorKey() {
        return UnauthenticatedException.class.getSimpleName();
    }
}
