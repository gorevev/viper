package com.gorevev.testapplication.domain.order.entities;


import java.io.Serializable;

import lombok.Data;

@Data
public class Contact implements Serializable {
    private String lastName;
    private String firstName;
    private String secondName;
    private String position;
    private String email;
    private String phone;
}
