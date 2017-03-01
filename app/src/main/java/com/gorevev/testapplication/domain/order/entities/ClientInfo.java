package com.gorevev.testapplication.domain.order.entities;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class ClientInfo implements Serializable {
    private int id;
    private int ownerId;
    private int legalStatusId;
    private Float ratingObservance;
    private Float ratingQuality;
    private Float ratingLoading;
    private Float ratingPayment;
    private Float ratingAvgConsignor;
    private Float ratingAvgCarrier;
    private CompanyInfo company;
}
