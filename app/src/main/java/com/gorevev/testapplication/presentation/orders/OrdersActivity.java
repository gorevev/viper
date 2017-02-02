package com.gorevev.testapplication.presentation.orders;

import android.os.Bundle;

import com.gorevev.testapplication.R;
import com.gorevev.testapplication.presentation.common.BaseActivity;
import com.gorevev.testapplication.presentation.common.Layout;

/**
 * Created by e.gorev on 30.01.2017.
 */

@Layout(R.layout.activity_base)
public class OrdersActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportFragmentManager().getBackStackEntryCount() == 0)
            addBackStack(new OrdersFragment());
    }
}
