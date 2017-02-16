package com.gorevev.testapplication.presentation.orderdetails;

import com.arellomobile.mvp.InjectViewState;

import com.gorevev.testapplication.domain.common.entities.Response;
import com.gorevev.testapplication.domain.order.OrderDetailsInteractor;
import com.gorevev.testapplication.domain.order.entities.OrderContainer;
import com.gorevev.testapplication.presentation._common.BasePresenter;
import com.gorevev.testapplication.presentation._common.IBaseRouter;

import javax.inject.Inject;

import rx.Subscriber;


@InjectViewState
public class OrderDetailsPresenter extends BasePresenter<IOrderDetailsView, IOrderRouter> {
    OrderDetailsInteractor interactor;

    @Inject
    public OrderDetailsPresenter(OrderDetailsInteractor interactor, IOrderRouter router) {
        setRouter(router);
        this.interactor = interactor;
    }

    public void loadOrder(int orderId) {
        getViewState().showProgress();

        interactor.execute(orderId)
                .subscribe(new Subscriber<Response<OrderContainer>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getViewState().hideProgress();
                        getViewState().showError(e.getMessage());
                    }

                    @Override
                    public void onNext(Response<OrderContainer> orderContainerBaseResponse) {
                        getViewState().hideProgress();
                        getViewState().showOrder(orderContainerBaseResponse.getData());
                    }
                });
    }

}
