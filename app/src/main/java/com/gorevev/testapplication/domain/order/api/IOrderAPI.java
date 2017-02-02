package com.gorevev.testapplication.domain.order.api;

import com.gorevev.testapplication.domain.order.entities.OrdersList;
import com.gorevev.testapplication.infrastructure.network.Response;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by e.gorev on 01.02.2017.
 */

public interface IOrderAPI {

    @GET("order")
    Observable<Response<OrdersList>> getOrders();
}
