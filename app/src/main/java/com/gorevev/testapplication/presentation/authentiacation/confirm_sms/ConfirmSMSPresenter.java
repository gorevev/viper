package com.gorevev.testapplication.presentation.authentiacation.confirm_sms;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.gorevev.testapplication.domain.user.ConfirmSMSInteractor;
import com.gorevev.testapplication.domain.user.ResendSMSInteractor;
import com.gorevev.testapplication.domain.user.StopWatchInteractor;
import com.gorevev.testapplication.domain.user.entities.SmsConfirmationCode;
import com.gorevev.testapplication.presentation._common.BasePresenter;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by denischuvasov on 14.02.17.
 */
@InjectViewState
public class ConfirmSMSPresenter extends BasePresenter<IConfirmSMSView, IConfirmSMSRouter> {
    private static final String TAG = "ConfirmSMSPresenter";
    private static final int DELAY = 5;

    private final ConfirmSMSInteractor interactor;
    private final ResendSMSInteractor resendSMSInteractor;
    private final StopWatchInteractor stopwatchInteractor;

    @Inject
    public ConfirmSMSPresenter(IConfirmSMSRouter router,
                               ConfirmSMSInteractor interactor,
                               ResendSMSInteractor resendSMSInteractor,
                               StopWatchInteractor stopwatchInteractor) {
        this.interactor = interactor;
        this.resendSMSInteractor = resendSMSInteractor;
        this.stopwatchInteractor = stopwatchInteractor;
        setRouter(router);
        resendConfirmCode();
        startTimer();
    }

    public void resendConfirmCode() {
        resendSMSInteractor.execute()
                .subscribe(response -> {
                    startTimer();
                }, throwable -> {
                    getViewState().showError(throwable);
                });
    }

    private void startTimer() {
        stopwatchInteractor.execute(DELAY)
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted() called");
                        getViewState().showResendButton();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError() called with: e = [" + e + "]");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.d(TAG, "onNext() called with: aLong = [" + aLong + "]");
                        getViewState().showRemainingTime(DELAY - aLong.intValue());
                    }
                });
    }

    public void confirmCode(String code) {
        interactor.execute(new SmsConfirmationCode(code))
                .subscribe(response -> {
                            router.showMainScreen();
                        },
                        throwable -> {
                            getViewState().showError(throwable);
                        });
    }

    public void onBackPressed() {
        router.back();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopwatchInteractor.unsubscribe();
        interactor.unsubscribe();
        resendSMSInteractor.unsubscribe();
    }
}
