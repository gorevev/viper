package com.gorevev.testapplication.utils;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by denischuvasov on 20.02.17.
 */

public class NetworkUtils {
    private NetworkUtils() {

    }

    public static boolean isNetworkAvailable(Context context) {
        final ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }
}
