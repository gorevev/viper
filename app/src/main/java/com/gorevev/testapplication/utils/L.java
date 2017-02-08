package com.gorevev.testapplication.utils;

import android.util.Log;

import com.gorevev.testapplication.BuildConfig;

/**
 * Created by denischuvasov on 08.02.17.
 */

public class L {
    public static void d(String tag, String message) {
        if(BuildConfig.DEBUG) {
            Log.d(tag, message);
        }
    }
}
