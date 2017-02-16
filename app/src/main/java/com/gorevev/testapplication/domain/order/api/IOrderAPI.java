package com.gorevev.testapplication.domain.order.api;

import com.gorevev.testapplication.domain.order.entities.OrderContainer;
import com.gorevev.testapplication.domain.order.entities.OrdersList;
import com.gorevev.testapplication.domain.common.entities.Response;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by e.gorev on 01.02.2017.
 */

public interface IOrderAPI {

    @GET("order")
    Observable<Response<OrdersList>> getOrders(@QueryMap Map<String, String> parameters);

    @GET("order/{id}")
    Observable<Response<OrderContainer>> order(@Path("id") int id);
}
