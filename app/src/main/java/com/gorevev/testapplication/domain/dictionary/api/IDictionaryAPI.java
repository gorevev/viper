package com.gorevev.testapplication.domain.dictionary.api;

import com.gorevev.testapplication.domain._common.entities.Response;
import com.gorevev.testapplication.domain.dictionary.entiny.TimezoneList;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by denischuvasov on 14.02.17.
 */

public interface IDictionaryAPI {
    @GET("timezone")
    Observable<Response<TimezoneList>> timezone();
}
