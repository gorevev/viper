package com.gorevev.testapplication.domain.order.entities;

import lombok.Getter;

@Getter
public class Point {
    private int id;
    private int clientId;
    private int clientNumber;
    private String title;
    private String address;
    private String code;
    private String localityName;
}
