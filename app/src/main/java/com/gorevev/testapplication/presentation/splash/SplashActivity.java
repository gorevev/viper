package com.gorevev.testapplication.presentation.splash;

import android.os.Bundle;

import com.gorevev.testapplication.R;
import com.gorevev.testapplication.infrastructure.App;
import com.gorevev.testapplication.presentation.common.BaseActivity;
import com.gorevev.testapplication.presentation.common.Layout;

/**
 * Created by Ginko on 16.11.2016.
 */

@Layout(R.layout.activity_base)
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportFragmentManager().getBackStackEntryCount() == 0)
            addBackStack(new SplashFragment());
    }

}
