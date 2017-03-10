package com.gorevev.testapplication.presentation.order_details;

import com.arellomobile.mvp.InjectViewState;

import com.gorevev.testapplication.domain.order.OrderDetailsInteractor;
import com.gorevev.testapplication.infrastructure.exceptions.ErrorResolver;
import com.gorevev.testapplication.presentation._common.BasePresenter;

import javax.inject.Inject;


@InjectViewState
public class OrderDetailsPresenter extends BasePresenter<IOrderDetailsView, IOrderRouter> {

    OrderDetailsInteractor interactor;

    @Inject
    public OrderDetailsPresenter(OrderDetailsInteractor interactor, IOrderRouter router, ErrorResolver errorResolver) {
        super(router, errorResolver);
        this.interactor = interactor;
    }

    public void loadOrder(int orderId) {
        getViewState().showProgress();

        interactor.execute(orderId)
                .subscribe(
                        orderContainerResponse -> {
                            getViewState().hideProgress();
                            getViewState().showOrder(orderContainerResponse.getData());
                        },
                        throwable -> {
                            getViewState().hideProgress();
                            getViewState().showError(throwable.getMessage());
                        }
                );
    }

}
