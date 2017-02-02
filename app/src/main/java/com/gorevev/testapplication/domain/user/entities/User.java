package com.gorevev.testapplication.domain.user.entities;

/**
 * Created by Ginko on 03.12.2016.
 */

public class User {

    private Token data;

    public Token getData() {
        return data;
    }

    public class Token {
        public String token;
    }

}
