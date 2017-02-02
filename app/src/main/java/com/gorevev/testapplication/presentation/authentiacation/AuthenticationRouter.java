package com.gorevev.testapplication.presentation.authentiacation;

import android.content.Context;
import android.content.Intent;

import com.gorevev.testapplication.presentation.orders.OrdersActivity;

/**
 * Created by e.gorev on 30.01.2017.
 */

public class AuthenticationRouter implements IAuthenticationRouter {

    Context context;

    public AuthenticationRouter(Context context) {
        this.context = context;
    }

    @Override
    public void showRoutesList() {
        Intent intent = new Intent(context, OrdersActivity.class);
        context.startActivity(intent);
    }
}
