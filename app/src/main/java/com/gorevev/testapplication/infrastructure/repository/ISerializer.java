package com.gorevev.testapplication.infrastructure.repository;

import android.support.annotation.NonNull;

/**
 * Created by Ginko on 17.11.2016.
 */

public interface ISerializer {

    String deserialize(@NonNull Object object);

    <T> T serialize(@NonNull String json, Class<T> cls);
}
