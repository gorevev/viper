package com.gorevev.testapplication.domain.order.entities;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class CompanyInfo implements Serializable {
    private String shortName;
    private String actualAddress;
    private String cityPhone;
    private String phone;
    private String legalName;
    private String headName;
    private String legalAddress;
    private String inn;
    private String orgn;
    private int isWithVAT;
}
