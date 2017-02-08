package com.gorevev.testapplication.presentation.orders;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.gorevev.testapplication.R;
import com.gorevev.testapplication.infrastructure.App;
import com.gorevev.testapplication.presentation.common.BaseFragment;
import com.gorevev.testapplication.presentation.common.Layout;

/**
 * Created by e.gorev on 30.01.2017.
 */

@Layout(R.layout.fragment_orders)
public class OrdersFragment extends BaseFragment implements IOrdersView {

    @InjectPresenter
    OrdersPresenter presenter;

    @ProvidePresenter
    OrdersPresenter providePresenter() {
        return App.getInstance().getRoutesListComponent(this).ordersPresenter();
    }

    @Override
    protected void inject() {

    }
}
