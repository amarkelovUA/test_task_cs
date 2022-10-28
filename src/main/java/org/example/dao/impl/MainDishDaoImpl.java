package org.example.dao.impl;

import java.util.List;
import org.example.dao.AbstractDao;
import org.example.dao.MainDishDao;
import org.example.model.MainDish;

public class MainDishDaoImpl extends AbstractDao<MainDish> implements MainDishDao {
    public MainDishDaoImpl(List<MainDish> database) {
        super(database);
    }
}
