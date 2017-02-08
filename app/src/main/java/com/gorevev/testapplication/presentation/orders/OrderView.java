package com.gorevev.testapplication.presentation.orders;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.gorevev.testapplication.R;
import com.gorevev.testapplication.domain.order.entities.Order;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderView extends FrameLayout {

    @BindView(R.id.id)
    protected TextView id;

    @BindView(R.id.action_button)
    protected AppCompatButton actionButton;

    private Order order;

    public OrderView(Context context) {
        this(context, null);
    }

    public OrderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OrderView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_order, this);
        ButterKnife.bind(this);
    }

    public void setOrder(Order order) {
        this.order = order;
        bindOrder();
    }

    private void bindOrder() {
        if (order != null) {
            id.setText(order.getId().toString());
        }
    }
}
