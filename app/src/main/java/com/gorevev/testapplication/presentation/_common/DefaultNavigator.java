package com.gorevev.testapplication.presentation._common;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.gorevev.testapplication.presentation.authentiacation.AuthTransitions;
import com.gorevev.testapplication.presentation.authentiacation.AuthenticationActivity;

/**
 * Created by e.gorev on 10.03.2017.
 */

public abstract class DefaultNavigator extends BaseNavigator {

    public DefaultNavigator(AppCompatActivity activity, int containerId) {
        super(activity, containerId);
    }

    protected Intent createIntent(Context context, String screenName, Object transferData) {

        switch (screenName) {
            case AuthTransitions.LOGIN:
                return AuthenticationActivity.createIntent(context, AuthTransitions.LOGIN);
        }

        return null;
    }
}
