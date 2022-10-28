package org.example.dao;

import java.util.List;

public class AbstractDao<T> implements GenericDao<T> {
    protected List<T> database;

    public AbstractDao(List<T> database) {
        this.database = database;
    }

    @Override
    public List<T> getAll() {
        return database;
    }

    @Override
    public T add(T entity) {
        database.add(entity);
        return entity;
    }
}
