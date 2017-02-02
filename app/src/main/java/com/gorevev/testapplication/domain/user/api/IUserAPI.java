package com.gorevev.testapplication.domain.user.api;

import com.gorevev.testapplication.domain.user.entities.LoginParams;
import com.gorevev.testapplication.domain.user.entities.RegUserParams;
import com.gorevev.testapplication.domain.user.entities.User;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Ginko on 06.12.2016.
 */

public interface IUserAPI {

    @POST("register")
    Observable<User> registerUser(@Body RegUserParams parameters);

    @POST("login")
    Observable<User> login(@Body LoginParams parameters);
}
