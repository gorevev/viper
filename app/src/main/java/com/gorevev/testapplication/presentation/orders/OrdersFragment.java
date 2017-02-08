package com.gorevev.testapplication.presentation.orders;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.gorevev.testapplication.R;
import com.gorevev.testapplication.domain.order.entities.Order;
import com.gorevev.testapplication.infrastructure.App;
import com.gorevev.testapplication.presentation.common.BaseFragment;
import com.gorevev.testapplication.presentation.common.Layout;

import java.util.List;

import butterknife.BindView;

/**
 * Created by e.gorev on 30.01.2017.
 */

@Layout(R.layout.fragment_orders)
public class OrdersFragment extends BaseFragment implements
        IOrdersView,
        OrderAdapter.OrderAdapterListener,
        SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.list)
    RecyclerView recyclerView;

    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    OrderAdapter orderAdapter;

    @InjectPresenter
    OrdersPresenter presenter;

    @ProvidePresenter
    OrdersPresenter providePresenter() {
        return App.getInstance().getOrdersComponent(this).ordersPresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        orderAdapter = new OrderAdapter(this);
        recyclerView.setAdapter(orderAdapter);
        refresh.setOnRefreshListener(this);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void addOrders(List<Order> orders, boolean mayBeMore) {
        orderAdapter.addOrders(orders, mayBeMore);
    }

    @Override
    public void setOrders(List<Order> orders, boolean mayBeMore) {
        orderAdapter.setOrders(orders, mayBeMore);
    }

    @Override
    public void onLoadMore() {
        presenter.loadOrders();
    }

    @Override
    public void onShowOrder(int orderId) {
        presenter.onShowOrder(orderId);
    }

    @Override
    public void onRefresh() {
        refresh.setRefreshing(false);
        orderAdapter.clearOrders();
        presenter.refreshOrders();
    }
}
