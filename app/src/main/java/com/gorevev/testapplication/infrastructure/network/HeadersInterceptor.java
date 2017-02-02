package com.gorevev.testapplication.infrastructure.network;

import com.gorevev.testapplication.infrastructure.network.headers.IHeader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by Ginko on 09.08.2016.
 */
public class HeadersInterceptor implements Interceptor {

    List<IHeader> headers = new ArrayList<>();

    public HeadersInterceptor(IHeader... headers) {

        for (IHeader header : headers)
            this.headers.add(header);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        if (headers.size() == 0)
            return chain.proceed(chain.request());

        Headers.Builder builder = new Headers.Builder();
        for (IHeader header : headers) {
            builder.add(header.getName(), header.getValue());
        }

        return chain.proceed(chain.request().newBuilder().headers(builder.build()).build());
    }
}
