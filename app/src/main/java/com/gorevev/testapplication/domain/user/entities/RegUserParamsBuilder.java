package com.gorevev.testapplication.domain.user.entities;

public class RegUserParamsBuilder {
    private boolean acceptOffer;
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

    public RegUserParamsBuilder setAcceptOffer(boolean acceptOffer) {
        this.acceptOffer = acceptOffer;
        return this;
    }

    public RegUserParamsBuilder setLegalStatus(int legalStatus) {
        this.legalStatus = legalStatus;
        return this;
    }

    public RegUserParamsBuilder setIsCarrier(boolean isCarrier) {
        this.isCarrier = isCarrier;
        return this;
    }

    public RegUserParamsBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public RegUserParamsBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public RegUserParamsBuilder setSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public RegUserParamsBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public RegUserParamsBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public RegUserParamsBuilder setTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    public RegUserParamsBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public RegUserParamsBuilder setAcceptPersonalData(boolean acceptPersonalData) {
        this.acceptPersonalData = acceptPersonalData;
        return this;
    }

    public RegUserParams createRegUserParams() {
        return new RegUserParams(acceptOffer, legalStatus, isCarrier, lastName, firstName, secondName, email, phone, timezone, password, acceptPersonalData);
    }
}