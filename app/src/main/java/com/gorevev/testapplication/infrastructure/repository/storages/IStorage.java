package com.gorevev.testapplication.infrastructure.repository.storages;

import com.gorevev.testapplication.infrastructure.repository.RepositoryException;

/**
 * Created by e.gorev on 02.02.2017.
 */

public interface IStorage<T> {

    T get();

    void put(T value) throws RepositoryException;
}
