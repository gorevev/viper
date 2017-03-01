package com.gorevev.testapplication.presentation.splash;

import android.os.Bundle;

import com.gorevev.testapplication.R;
import com.gorevev.testapplication.infrastructure.App;
import com.gorevev.testapplication.presentation.authentiacation.AuthenticationActivity;
import com.gorevev.testapplication.presentation._common.BaseActivity;
import com.gorevev.testapplication.presentation._common.Layout;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Replace;

/**
 * Created by Ginko on 16.11.2016.
 */

@Layout(R.layout.activity_base)
public class SplashActivity extends BaseActivity {

    @Override
    protected Navigator createNavigator() {
        return new SplashNavigator(this, R.id.content);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.getInstance().getSplashComponent().inject(this);

        if (getSupportFragmentManager().getBackStackEntryCount() == 0)
            router.replaceScreen(SplashTransitions.START_PAGE);
    }
}
