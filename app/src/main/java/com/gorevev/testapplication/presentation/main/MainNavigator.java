package com.gorevev.testapplication.presentation.main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.gorevev.testapplication.presentation._common.BaseNavigator;
import com.gorevev.testapplication.presentation.authentiacation.AuthenticationActivity;
import com.gorevev.testapplication.presentation.main.orders.OrdersFragment;
import com.gorevev.testapplication.presentation.order_details.OrderDetailsActivity;

/**
 * Created by denischuvasov on 10.02.17.
 */

public class MainNavigator extends BaseNavigator {

    public MainNavigator(AppCompatActivity activity, @IdRes int container) {
        super(activity, container);
    }

    @Override
    protected Intent createIntent(Context context, String screenName, Object transferData) {
        //TODO show order details
        switch (screenName) {
            case MainTransitions.AUTHENTICATION_SCREEN:
                return AuthenticationActivity.createIntent(context);
            case MainTransitions.ORDER_DETAILS_SCREEN:
                return OrderDetailsActivity.createIntent(context, (Integer) transferData);
        }
        return null;
    }

    @Override
    protected Fragment createFragment(String screenKey, Object data) {
        switch (screenKey) {
            case MainTransitions.ORDERS:
                return OrdersFragment.newInstance();
        }

        return null;
    }
}
