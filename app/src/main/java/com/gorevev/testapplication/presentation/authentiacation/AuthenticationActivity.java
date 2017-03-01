package com.gorevev.testapplication.presentation.authentiacation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.gorevev.testapplication.R;
import com.gorevev.testapplication.infrastructure.App;
import com.gorevev.testapplication.presentation._common.BaseActivity;
import com.gorevev.testapplication.presentation._common.Layout;

import ru.terrakok.cicerone.Navigator;

@Layout(R.layout.activity_base)
public class AuthenticationActivity extends BaseActivity {

    @Override
    protected Navigator createNavigator() {
        return new AuthenticationNavigator(this, R.id.content);
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, AuthenticationActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.getInstance().getAuthenticationComponent().inject(this);

        //TODO make switching between start page and login on start context
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            router.replaceScreen(AuthTransitions.START_PAGE);
        }
    }
}
