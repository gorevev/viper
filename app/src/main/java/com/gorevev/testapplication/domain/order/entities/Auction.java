package com.gorevev.testapplication.domain.order.entities;

import lombok.Getter;

@Getter
public class Auction {
    private int rebidMinute;
    private int extensionPeriod;
    private int orderId;
    private double openingBid;
    private double stepBid;
    private int increasePercent;
    private String endDate;
}
