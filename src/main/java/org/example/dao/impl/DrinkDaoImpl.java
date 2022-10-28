package org.example.dao.impl;

import java.util.List;
import org.example.dao.AbstractDao;
import org.example.dao.DrinkDao;
import org.example.model.Drink;

public class DrinkDaoImpl extends AbstractDao<Drink> implements DrinkDao {
    public DrinkDaoImpl(List<Drink> database) {
        super(database);
    }
}
