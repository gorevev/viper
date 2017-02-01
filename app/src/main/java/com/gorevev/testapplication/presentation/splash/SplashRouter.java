package com.gorevev.testapplication.presentation.splash;

import android.content.Context;
import android.content.Intent;

import com.gorevev.testapplication.presentation.authentiacation.AuthenticationActivity;

/**
 * Created by Ginko on 07.12.2016.
 */

public class SplashRouter implements ISplashRouter {

    Context context;

    public SplashRouter(Context context) {
        this.context = context;
    }

    @Override
    public void openLogin() {

        Intent intent = new Intent(context, AuthenticationActivity.class);
        context.startActivity(intent);
    }
}
