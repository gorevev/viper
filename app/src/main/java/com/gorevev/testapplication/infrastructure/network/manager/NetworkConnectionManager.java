package com.gorevev.testapplication.infrastructure.network.manager;

import android.content.Context;
import android.util.Log;

import com.gorevev.testapplication.utils.NetworkUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.inject.Inject;

/**
 * Created by denischuvasov on 20.02.17.
 */

public class NetworkConnectionManager {

    private final Context context;
    private final int count;
    private final long delay;

    @Inject
    public NetworkConnectionManager(Context context) {
        this.context = context;
        this.count = 3;
        this.delay = 2000L;
    }

    public boolean isActiveInternetConnection() {
        if(NetworkUtils.isNetworkAvailable(context)) {
            try {
                HttpURLConnection urlConnection = (HttpURLConnection) new URL("http://www.google.com").openConnection();
                urlConnection.setRequestProperty("User-Agent", "Test");
                urlConnection.setRequestProperty("Connection", "close");
                urlConnection.setConnectTimeout(1500);
                urlConnection.connect();
                return urlConnection.getResponseCode() == 200;

            } catch (IOException e) {
                Log.e("network", "Error checking internet connection", e);
                e.printStackTrace();
            }
        } else {
            Log.d("network", "No network available!");
        }

        return false;
    }

    public int getCount() {
        return count;
    }

    public long getDelay() {
        return delay;
    }
}
