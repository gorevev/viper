package com.gorevev.testapplication.infrastructure.network.headers;

import com.gorevev.testapplication.infrastructure.repository.storages.IStorage;
import com.gorevev.testapplication.infrastructure.repository.storages.TokenStorage;

import javax.inject.Inject;

/**
 * Created by e.gorev on 02.02.2017.
 */

public class AuthorizationHeader implements IHeader {

    private static final String HEADER_NAME = "Authorization";

    IStorage<String> storage;

    @Inject
    public AuthorizationHeader(TokenStorage storage) {
        this.storage = storage;
    }

    @Override
    public String getName() {
        return HEADER_NAME;
    }

    @Override
    public String getValue() {
        return storage.get();
    }
}
