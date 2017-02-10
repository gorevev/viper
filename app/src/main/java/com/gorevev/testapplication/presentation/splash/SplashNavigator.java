package com.gorevev.testapplication.presentation.splash;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.gorevev.testapplication.presentation._common.BaseNavigator;
import com.gorevev.testapplication.presentation.authentiacation.AuthenticationActivity;
import com.gorevev.testapplication.presentation.main.MainActivity;

/**
 * Created by denischuvasov on 10.02.17.
 */

public class SplashNavigator extends BaseNavigator {

    public SplashNavigator(AppCompatActivity activity, @IdRes Integer container) {
        super(activity, container);
    }

    @Override
    protected Intent createIntent(String screenName, Object transferData) {
        switch (screenName) {
            case SplashTransitions.AUTHENTICATION:
                return AuthenticationActivity.createIntent(activity);
            case SplashTransitions.MAIN_SCREEN:
                return MainActivity.createIntent(activity);
        }

        return null;
    }

    @Override
    protected Fragment createFragment(String screenKey, Object data) {
        switch (screenKey) {
            case SplashTransitions.START_PAGE:
                return SplashFragment.newInstance();
        }
        return null;
    }
}
