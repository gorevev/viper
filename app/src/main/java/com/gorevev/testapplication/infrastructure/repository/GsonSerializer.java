package com.gorevev.testapplication.infrastructure.repository;

import android.support.annotation.NonNull;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Ginko on 17.11.2016.
 */

public class GsonSerializer implements ISerializer {

    Gson gson;

    public GsonSerializer() {
        gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    }

    @Override
    public String deserialize(@NonNull Object object) {
        return gson.toJson(object);
    }

    @Override
    public <T> T serialize(@NonNull String json, Class<T> cls) {
        return gson.fromJson(json, cls);
    }
}
