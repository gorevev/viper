package com.gorevev.testapplication.infrastructure.repository;

/**
 * Created by Ginko on 17.11.2016.
 */

public interface IRepository {

    void put(String key, Object object) throws RepositoryException;

    <T> T get(String key, Class<T> cls);
}
