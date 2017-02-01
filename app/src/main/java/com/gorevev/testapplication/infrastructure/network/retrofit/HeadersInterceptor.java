package com.gorevev.testapplication.infrastructure.network.retrofit;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Ginko on 09.08.2016.
 */
public class HeadersInterceptor implements Interceptor {

    private Headers headers;

    @Override
    public Response intercept(Chain chain) throws IOException {

        if (headers == null)
            return chain.proceed(chain.request());

        Request original = chain.request();

        Request.Builder request = original.newBuilder();
        for (int i = 0; i < headers.size(); i++)
            request.header(headers.name(i), headers.value(i));

        request = request.method(original.method(), original.body());

        return chain.proceed(request.build());
    }

    public void setHeaders(Headers headers) {

        this.headers = headers;
    }

    public void setHeader(String name, String value) {

        headers = headers.newBuilder().set(name, value).build();
    }
}
