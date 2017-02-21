package com.gorevev.testapplication.presentation.orderdetails;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.gorevev.testapplication.R;
import com.gorevev.testapplication.domain.order.entities.OrderContainer;
import com.gorevev.testapplication.infrastructure.App;
import com.gorevev.testapplication.presentation._common.BaseFragment;
import com.gorevev.testapplication.presentation._common.Layout;
import com.gorevev.testapplication.presentation.main.orders.OrderView;

import butterknife.BindView;


@Layout(R.layout.fragment_order_details)
public class OrderDetailsFragment extends BaseFragment implements IOrderDetailsView {
    private static final String KEY_ORDER_ID = "ORDER_ID";

    @BindView(R.id.order)
    OrderView orderView;

    @BindView(R.id.progressbar)
    View progressbarView;

    @InjectPresenter
    OrderDetailsPresenter presenter;

    @ProvidePresenter
    OrderDetailsPresenter provideDetailPresenter() {
        int orderId = getArguments().getInt(KEY_ORDER_ID);
        OrderDetailsPresenter presenter = App.getInstance().getOrderDetailsComponent().orderDetailsPresenter();
        presenter.loadOrder(orderId);
        return presenter;
    }

    public static OrderDetailsFragment newInstance(int orderId) {
        Bundle args = new Bundle();
        args.putInt(KEY_ORDER_ID, orderId);
        OrderDetailsFragment fragment = new OrderDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void showError(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showOrder(OrderContainer orderContainer) {
        orderView.setOrder(orderContainer.getOrder());
    }

    @Override
    public void showProgress() {
        progressbarView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressbarView.setVisibility(View.GONE);
    }

    @Override
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }
}
