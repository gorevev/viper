package com.gorevev.testapplication.infrastructure.repository;

/**
 * Created by Ginko on 17.11.2016.
 */

public interface IRepository {

    void put(Object object, String key) throws RepositoryException;

    <T> T get(String key, Class<T> cls);
}
