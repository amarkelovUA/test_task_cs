package org.example.dao;

import java.util.List;

public interface GenericDao<T> {
    List<T> getAll();

    T add(T goods);
}
