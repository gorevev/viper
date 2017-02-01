package com.gorevev.testapplication.domain.user.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by e.gorev on 30.01.2017.
 */

public class LoginParams {

    @SerializedName("LoginForm[login]")
    private String login;

    @SerializedName("LoginForm[password]")
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
