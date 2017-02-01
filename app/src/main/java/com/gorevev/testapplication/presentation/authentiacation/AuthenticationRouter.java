package com.gorevev.testapplication.presentation.authentiacation;

import android.content.Context;
import android.content.Intent;

import com.gorevev.testapplication.presentation.routes.RoutesListActivity;

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
        Intent intent = new Intent(context, RoutesListActivity.class);
        context.startActivity(intent);
    }
}