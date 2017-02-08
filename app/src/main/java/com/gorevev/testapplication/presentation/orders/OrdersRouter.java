package com.gorevev.testapplication.presentation.orders;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by e.gorev on 01.02.2017.
 */

public class OrdersRouter implements IOrdersRouter {

    private Context context;

    public OrdersRouter(Context context) {
        this.context = context;
    }

    @Override
    public void onShowOrder(int id) {
        Toast.makeText(context, "show details for " + String.valueOf(id), Toast.LENGTH_LONG).show();
    }
}
