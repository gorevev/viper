package com.gorevev.testapplication.domain.order.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * Created by e.gorev on 01.02.2017.
 */

@Data
public class OrdersList {

    @SerializedName("order")
    private List<Order> orders;

    private int total;

    public void addOrders(OrdersList list) {

        if (orders == null)
            orders = new ArrayList<>();

        orders.addAll(list.getOrders());
    }

    public boolean mayBeMore() {
        return orders.size() < total ? true : false;
    }
}
