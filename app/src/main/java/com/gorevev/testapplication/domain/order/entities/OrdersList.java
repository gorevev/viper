package com.gorevev.testapplication.domain.order.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e.gorev on 01.02.2017.
 */

public class OrdersList {

    @SerializedName("order")
    private List<Order> orders;

    private int total;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrders(OrdersList list) {

        if (orders == null)
            orders = new ArrayList<>();

        orders.addAll(list.getOrders());
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean mayBeMore() {
        return orders.size() < total ? true : false;
    }
}
