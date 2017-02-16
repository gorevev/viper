package com.gorevev.testapplication.presentation.orderdetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.gorevev.testapplication.R;
import com.gorevev.testapplication.infrastructure.App;
import com.gorevev.testapplication.presentation._common.BaseActivity;
import com.gorevev.testapplication.presentation._common.BaseNavigator;
import com.gorevev.testapplication.presentation._common.Layout;

import ru.terrakok.cicerone.Navigator;

@Layout(R.layout.activity_order_details)
public class OrderDetailsActivity extends BaseActivity {

    private static final String KEY_ORDER_ID = "ORDER_ID";

    public static Intent createIntent(Context context, Integer orderId) {
        Intent intent = new Intent(context, OrderDetailsActivity.class);
        intent.putExtra(KEY_ORDER_ID, orderId);
        return intent;
    }

    @Override
    protected Navigator createNavigator() {
        return new OrderDetailsNavigator(this, R.id.content);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getInstance().getOrderDetailsComponent().inject(this);
        if(savedInstanceState == null) {
            int orderId = getIntent().getIntExtra(KEY_ORDER_ID, -1);
            router.replaceScreen(OrderDetailsTransitions.ORDER_DETAILS, orderId);
        }
    }
}
