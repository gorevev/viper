package com.gorevev.testapplication.presentation.main.orders;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gorevev.testapplication.R;
import com.gorevev.testapplication.domain.order.entities.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denischuvasov on 19.01.17.
 */

public class OrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 1;
    private static final int TYPE_LOADING = 2;

    private List<Order> data = new ArrayList<>();

    private boolean maybeMore = true;

    private OrderAdapterListener listener;

    public OrderAdapter(@NonNull OrderAdapterListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        return position == data.size() ? TYPE_LOADING : TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
            return new OrderViewHolder(view);
        }

        if(viewType == TYPE_LOADING) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_progress_bar, parent, false);
            return new ProgressHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof OrderViewHolder) {
            ((OrderViewHolder) holder).bind(data.get(position));
        }

        int preloadPosition = Math.max(0, data.size() - 3);
        if(position >= preloadPosition && maybeMore)
            listener.onLoadMore();
    }

    public void clearOrders() {
        data.clear();
        notifyDataSetChanged();
    }

    public void addOrders(List<Order> orders, boolean maybeMore) {
        data.addAll(orders);
        dataSetChanged(maybeMore);
    }

    public void setOrders(List<Order> orders, boolean maybeMore) {
        data.clear();
        addOrders(orders, maybeMore);
    }

    private void dataSetChanged(boolean maybeMore) {
        this.maybeMore = maybeMore;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size() + (maybeMore ? 1 : 0);
    }

    private class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private OrderView orderView;
        private Order order;

        OrderViewHolder(View itemView) {
            super(itemView);
            orderView = (OrderView) itemView.findViewById(R.id.order);
            orderView.setOnClickListener(this);
        }

        public void bind(Order order) {
            this.order = order;
            orderView.setOrder(order);
        }

        @Override
        public void onClick(View v) {
            if(listener != null)
                listener.onShowOrder(order.getId());
        }
    }

    private class ProgressHolder extends RecyclerView.ViewHolder {
        ProgressHolder(View itemView) {
            super(itemView);
        }
    }

    public interface OrderAdapterListener {
        void onLoadMore();
        void onShowOrder(int orderId);
    }
}
