package com.gorevev.testapplication.domain.user.api;

import com.gorevev.testapplication.domain.common.entities.EmptyResponse;
import com.gorevev.testapplication.domain.common.entities.Response;
import com.gorevev.testapplication.domain.user.entities.LoginParams;
import com.gorevev.testapplication.domain.user.entities.RegUserParams;
import com.gorevev.testapplication.domain.user.entities.SmsConfirmationCode;
import com.gorevev.testapplication.domain.user.entities.Token;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Ginko on 06.12.2016.
 */

public interface IUserAPI {

    @POST("register")
    Observable<Response<Token>> registerUser(@Body RegUserParams parameters);

    @POST("login")
    Observable<Response<Token>> login(@Body LoginParams parameters);

    @POST("user/sms-code/confirm")
    Observable<EmptyResponse> smsCodeConfirm(@Body SmsConfirmationCode body);

    @POST("user/sms-code/resend")
    Observable<EmptyResponse> smsCodeResend();
}
