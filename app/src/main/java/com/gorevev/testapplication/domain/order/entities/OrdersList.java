package com.gorevev.testapplication.domain.order.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by e.gorev on 01.02.2017.
 */

public class OrdersList {

    @SerializedName("order")
    private List<Order> list;

    public List<Order> getList() {
        return list;
    }

    public void setList(List<Order> list) {
        this.list = list;
    }
}
