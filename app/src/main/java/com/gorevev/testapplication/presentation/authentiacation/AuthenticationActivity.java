package com.gorevev.testapplication.presentation.authentiacation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

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
        return createIntent(context, null);
    }

    public static Intent createIntent(Context context, @Nullable String screen) {
        if (screen == null)
            return new Intent(context, AuthenticationActivity.class).putExtra(AuthTransitions.class.getSimpleName(), AuthTransitions.START_PAGE);
        else
            return new Intent(context, AuthenticationActivity.class).putExtra(AuthTransitions.class.getSimpleName(), screen);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.getInstance().getAuthenticationComponent().inject(this);

        if (getSupportFragmentManager().getBackStackEntryCount() == 0)
            router.replaceScreen(getIntent().getStringExtra(AuthTransitions.class.getSimpleName()));
    }
}
