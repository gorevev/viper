package com.gorevev.testapplication.presentation.orders.injection;

import com.gorevev.testapplication.domain.order.GetOrdersInteractor;
import com.gorevev.testapplication.presentation.common.BaseFragment;
import com.gorevev.testapplication.presentation.common.injection.ScreenScope;
import com.gorevev.testapplication.presentation.orders.IOrdersPresenter;
import com.gorevev.testapplication.presentation.orders.IOrdersRouter;
import com.gorevev.testapplication.presentation.orders.OrdersPresenter;
import com.gorevev.testapplication.presentation.orders.OrdersRouter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by e.gorev on 01.02.2017.
 */

@Module
public class OrdersModule {

    private BaseFragment fragment;

    public OrdersModule(BaseFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @ScreenScope
    public IOrdersRouter providesRouter() {
        return new OrdersRouter(fragment.getActivity());
    }

    @Provides
    @ScreenScope
    public IOrdersPresenter providesPresenter(IOrdersRouter router, GetOrdersInteractor getOrdersInteractor) {
        return new OrdersPresenter(router, getOrdersInteractor);
    }
}
