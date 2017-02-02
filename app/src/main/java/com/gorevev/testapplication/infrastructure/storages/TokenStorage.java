package com.gorevev.testapplication.infrastructure.storages;

import com.gorevev.testapplication.infrastructure.repository.IRepository;
import com.gorevev.testapplication.infrastructure.repository.IStorage;
import com.gorevev.testapplication.infrastructure.repository.RepositoryException;

import javax.inject.Inject;

/**
 * Created by e.gorev on 01.02.2017.
 */

public class TokenStorage implements IStorage<String> {

    public static final String TAG = TokenStorage.class.getName();
    public static final String KEY_TOKEN = TAG + ".token";

    private IRepository repository;

    @Inject
    public TokenStorage(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public String get() {
        return repository.get(KEY_TOKEN, String.class);
    }

    @Override
    public void put(String value) throws RepositoryException {
        repository.put(KEY_TOKEN, value);
    }

}
