package com.gorevev.testapplication.presentation._common.resolution;

import android.util.Log;

import com.gorevev.testapplication.infrastructure.exception.InternetConnectionException;
import com.gorevev.testapplication.infrastructure.exception.NotFoundException;
import com.gorevev.testapplication.infrastructure.exception.ServerException;
import com.gorevev.testapplication.infrastructure.exception.UpgradeRequiredException;

/**
 * Created by denischuvasov on 21.02.17.
 */

public class ThrowableResolver implements IThrowableResolver {
    private static final String TAG = "ThrowableResolver";

    @Override
    public void handleError(Throwable throwable) {
        if(throwable instanceof InternetConnectionException) {
            showNoConnectionError();

        } else if (throwable instanceof NotFoundException){
            showNotFoundError();

        } else if(throwable instanceof UpgradeRequiredException) {
            showUpdateScreen();

        } else if(throwable instanceof ServerException) {
            showServerError();

        } else {
            showUnknownError(throwable);
        }
    }

    private void showUnknownError(Throwable throwable) {
        Log.d(TAG, "showUnknownError() called with: throwable = [" + throwable + "]");
    }

    private void showServerError() {
        Log.d(TAG, "showServerError() called");
    }

    private void showUpdateScreen() {
        Log.d(TAG, "showUpdateScreen() called");
    }

    private void showNotFoundError() {
        Log.d(TAG, "showNotFoundError() called");
    }

    private void showNoConnectionError() {
        Log.d(TAG, "showNoConnectionError() called");
    }
}
