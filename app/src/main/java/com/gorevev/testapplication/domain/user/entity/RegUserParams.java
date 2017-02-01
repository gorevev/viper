package com.gorevev.testapplication.domain.user.entity;

/**
 * Created by Ginko on 04.12.2016.
 */

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

    public int getLegalStatus() {
        return legalStatus;
    }

    public void setLegalStatus(int legalStatus) {
        this.legalStatus = legalStatus;
    }

    public boolean isCarrier() {
        return isCarrier;
    }

    public void setCarrier(boolean carrier) {
        isCarrier = carrier;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAcceptPersonalData() {
        return acceptPersonalData;
    }

    public void setAcceptPersonalData(boolean acceptPersonalData) {
        this.acceptPersonalData = acceptPersonalData;
    }

    public boolean isAcceptOffer() {
        return acceptOffer;
    }

    public void setAcceptOffer(boolean acceptOffer) {
        this.acceptOffer = acceptOffer;
    }
}
