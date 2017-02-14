package com.gorevev.testapplication.presentation.authentiacation.confirmSms;

import com.arellomobile.mvp.InjectViewState;
import com.gorevev.testapplication.domain.user.ConfirmSMSInteractor;
import com.gorevev.testapplication.domain.user.ResendSMSInteractor;
import com.gorevev.testapplication.domain.user.entities.SmsConfirmationCode;
import com.gorevev.testapplication.presentation._common.BasePresenter;

import javax.inject.Inject;

/**
 * Created by denischuvasov on 14.02.17.
 */
@InjectViewState
public class ConfirmSMSPresenter extends BasePresenter<IConfirmSMSView, IConfirmSMSRouter> {

    private final ConfirmSMSInteractor interactor;
    private final ResendSMSInteractor resendSMSInteractor;

    @Inject
    public ConfirmSMSPresenter(IConfirmSMSRouter router, ConfirmSMSInteractor interactor, ResendSMSInteractor resendSMSInteractor) {
        this.interactor = interactor;
        this.resendSMSInteractor = resendSMSInteractor;
        setRouter(router);
        resendConfirmCode();
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
}
