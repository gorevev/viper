package com.gorevev.testapplication.presentation.authentiacation;

import android.os.Bundle;

import com.gorevev.testapplication.R;
import com.gorevev.testapplication.presentation.common.BaseActivity;
import com.gorevev.testapplication.presentation.common.Layout;

@Layout(R.layout.activity_base)
public class AuthenticationActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportFragmentManager().getBackStackEntryCount() == 0)
            addBackStack(new LoginFragment());
    }
}
