package com.gorevev.testapplication.presentation.orderdetails;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.gorevev.testapplication.presentation._common.BaseNavigator;

/**
 * Created by denischuvasov on 16.02.17.
 */

public class OrderDetailsNavigator extends BaseNavigator {
    public OrderDetailsNavigator(AppCompatActivity activity, int containerId) {
        super(activity, containerId);
    }

    @Nullable
    @Override
    protected Intent createIntent(Context context, String screenName, Object transferData) {
        return null;
    }

    @Override
    protected Fragment createFragment(String screenKey, Object data) {
        switch (screenKey) {
            case OrderDetailsTransitions.ORDER_DETAILS:
                return OrderDetailsFragment.newInstance((Integer)data);
        }

        return null;
    }
}
