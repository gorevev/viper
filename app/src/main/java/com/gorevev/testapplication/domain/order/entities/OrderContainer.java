package com.gorevev.testapplication.domain.order.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;

@Getter
public class OrderContainer {
    private Order order;
    private ClientInfo client;
    @SerializedName("contact")
    private List<Contact> contacts;
    private String serverDate;
}
