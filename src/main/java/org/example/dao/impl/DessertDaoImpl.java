package org.example.dao.impl;

import java.util.List;
import org.example.dao.AbstractDao;
import org.example.dao.DessertDao;
import org.example.model.Dessert;

public class DessertDaoImpl extends AbstractDao<Dessert> implements DessertDao {
    public DessertDaoImpl(List<Dessert> database) {
        super(database);
    }
}
