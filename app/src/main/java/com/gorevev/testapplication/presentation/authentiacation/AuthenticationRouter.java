package com.gorevev.testapplication.presentation.authentiacation;

import android.content.Intent;

import com.gorevev.testapplication.infrastructure.CurrentActivityProvider;
import com.gorevev.testapplication.presentation.common.BaseFragment;
import com.gorevev.testapplication.presentation.orders.OrdersActivity;

/**
 * Created by e.gorev on 30.01.2017.
 */

public class AuthenticationRouter implements IAuthenticationRouter {

    CurrentActivityProvider provider;

    public AuthenticationRouter(CurrentActivityProvider provider) {
        this.provider = provider;
    }

    @Override
    public void showOrders() {

        provider.getCurrentActivity().finish();

        Intent intent = new Intent(provider.getCurrentActivity(), OrdersActivity.class);
        provider.getCurrentActivity().startActivity(intent);
    }
}
