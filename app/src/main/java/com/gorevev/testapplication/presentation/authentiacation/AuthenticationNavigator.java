package com.gorevev.testapplication.presentation.authentiacation;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.gorevev.testapplication.presentation._common.BaseNavigator;
import com.gorevev.testapplication.presentation.authentiacation.login.LoginFragment;
import com.gorevev.testapplication.presentation.authentiacation.registration.RegistrationFragment;
import com.gorevev.testapplication.presentation.authentiacation.startpage.StartPageFragment;
import com.gorevev.testapplication.presentation.main.MainActivity;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;
import ru.terrakok.cicerone.commands.Replace;

/**
 * Created by denischuvasov on 10.02.17.
 */

public class AuthenticationNavigator extends BaseNavigator {

    public AuthenticationNavigator(AppCompatActivity activity, @IdRes int container) {
        super(activity, container);
    }

    @Override
    protected Intent createIntent(String screenName, Object transferData) {
        switch (screenName) {
            case AuthTransitions.MAIN_SCREEN:
                return new Intent(activity, MainActivity.class);
        }

        return null;
    }

    @Override
    protected Fragment createFragment(String screenKey, Object data) {
        switch (screenKey) {
            case AuthTransitions.LOGIN:
                return LoginFragment.newInstance();
            case AuthTransitions.START_PAGE:
                return StartPageFragment.newInstance();
            case AuthTransitions.REGISTRATION:
                return RegistrationFragment.newInstance();
        }
        return null;
    }
}
