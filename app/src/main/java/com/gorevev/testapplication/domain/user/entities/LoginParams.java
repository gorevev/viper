package com.gorevev.testapplication.domain.user.entities;

import lombok.Getter;

/**
 * Created by e.gorev on 30.01.2017.
 */

@Getter
public class LoginParams {

    private String login;

    private String password;

    public LoginParams(String login, String password) {

        this.login = login;
        this.password = password;
    }
}
