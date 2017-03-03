package com.gorevev.testapplication.infrastructure.repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.gorevev.testapplication.R;

/**
 * Created by Ginko on 17.11.2016.
 */

public class SharedPreferencesRepository implements IRepository {

    private Context context;
    private SharedPreferences sharedPreferences;
    private ISerializer serializer;

    public SharedPreferencesRepository(Context context, ISerializer serializer) {

        this.context = context;
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.serializer = serializer;
    }

    @Override
    public void put(String key, Object object) throws RepositoryException {
        if (!sharedPreferences.edit().putString(key, serializer.deserialize(object)).commit())
            throw new RepositoryException(context.getString(R.string.repository_put_exception));
    }

    @Override
    public <T> T get(String key, Class<T> cls) {

        String item = sharedPreferences.getString(key, null);

        if (item == null)
            return null;

        return serializer.serialize(item, cls);
    }
}
