package com.gorevev.testapplication.infrastructure.rx;

import android.accounts.NetworkErrorException;
import android.support.annotation.NonNull;

import com.gorevev.testapplication.infrastructure.exception.ApiErrorExceptionFactory;
import com.gorevev.testapplication.infrastructure.exception.InternetConnectionException;
import com.gorevev.testapplication.infrastructure.exception.ServerException;
import com.gorevev.testapplication.infrastructure.exception.UncheckedException;
import com.gorevev.testapplication.infrastructure.network.manager.NetworkConnectionManager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by denischuvasov on 20.02.17.
 */

public class RxRestApiFunctions {

    public static <R> Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> networkNoAvailableRetry(
            final Observable<R> toBeResumed,
            final NetworkConnectionManager networkConnectionManager) {

        return new Func1<Observable<? extends Throwable>, Observable<?>>() {

            private int retriesCount = 0;

            @Override
            public Observable<?> call(Observable<? extends Throwable> attempts) {
                return attempts
                        .flatMap(throwable -> {

                            if (throwable instanceof HttpException) {
                                int code = ((HttpException) throwable).code();
                                if (code / 100 == 4) {
                                    return Observable.error(ApiErrorExceptionFactory.fromHttpException((HttpException) throwable));
                                }
                            }

                            if (++retriesCount <= networkConnectionManager.getCount()) {
                                if (!networkConnectionManager.isActiveInternetConnection()) {
                                    return Observable.timer(networkConnectionManager.getDelay(), TimeUnit.MICROSECONDS);
                                } else {
                                    return toBeResumed;
                                }
                            }

                            return handleError(throwable);
                        });
            }
        };
    }

    @NonNull
    private static Observable<?> handleError(Throwable throwable) {
        if (throwable instanceof HttpException) {

            int code = ((HttpException) throwable).code();
            if (code / 500 == 5) {
                return Observable.error(new ServerException(throwable));
            } else {
                return Observable.error(new UncheckedException(throwable));
            }
        } else if (throwable instanceof IOException) {
            return Observable.error(new InternetConnectionException(throwable));
        } else if (throwable instanceof NetworkErrorException) {
            return Observable.error(new InternetConnectionException(throwable));
        }

        return Observable.error(throwable);
    }
}
