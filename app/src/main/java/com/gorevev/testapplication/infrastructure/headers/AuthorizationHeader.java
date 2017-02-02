package com.gorevev.testapplication.infrastructure.headers;

import com.gorevev.testapplication.infrastructure.network.IHeader;
import com.gorevev.testapplication.infrastructure.repository.IStorage;
import com.gorevev.testapplication.infrastructure.storages.TokenStorage;

import javax.inject.Inject;

/**
 * Created by e.gorev on 02.02.2017.
 */

public class AuthorizationHeader implements IHeader {

    private static final String HEADER_NAME = "Authorization";

    private IStorage<String> storage;

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
