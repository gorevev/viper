package com.gorevev.testapplication.domain.order.entities;

import lombok.Getter;

@Getter
public class Bid {
    private int id;
    private int orderId;
    private int bidValue;
    private int delivery;
}
