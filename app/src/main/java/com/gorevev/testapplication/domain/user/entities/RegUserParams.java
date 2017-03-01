package com.gorevev.testapplication.domain.user.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Ginko on 04.12.2016.
 */

@Builder
@Getter
@Setter
public class RegUserParams {

    private int legalStatus;
    private boolean isCarrier;
    private String lastName;
    private String firstName;
    private String secondName;
    private String email;
    private String phone;
    private String timezone;
    private String password;
    private boolean acceptPersonalData;
    private boolean acceptOffer;
}
