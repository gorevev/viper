package com.gorevev.testapplication.presentation.authentiacation.registration;

import com.arellomobile.mvp.InjectViewState;
import com.gorevev.testapplication.domain.user.RegistrationInteractor;
import com.gorevev.testapplication.domain.user.entities.RegUserParams;
import com.gorevev.testapplication.infrastructure.exceptions.ErrorResolver;
import com.gorevev.testapplication.presentation._common.BasePresenter;

import javax.inject.Inject;


/**
 * Created by denischuvasov on 13.02.17.
 */

@InjectViewState
public class RegistrationPresenter extends BasePresenter<IRegistrationView, IRegistrationRouter> {

    private final RegistrationInteractor interactor;

    @Inject
    public RegistrationPresenter(IRegistrationRouter router, RegistrationInteractor interactor, ErrorResolver errorResolver) {
        super(router, errorResolver);
        this.interactor = interactor;
    }

    public void registration(RegUserParams regUserParams) {
        getViewState().showProgress();
        interactor.execute(regUserParams)
                .subscribe(
                        response->{
                            getViewState().hideProgress();
                            getViewState().showConfirmDialog();
                        },
                        throwable -> {
                            getViewState().hideProgress();
                            getViewState().showSnackbar(throwable);
                        }
                );
    }
}
