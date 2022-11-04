package org.example.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import org.example.dao.DessertDao;
import org.example.dao.DrinkDao;
import org.example.dao.MainDishDao;
import org.example.model.Dessert;
import org.example.model.Drink;
import org.example.model.MainDish;
import org.example.service.MenuService;

@AllArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final DessertDao dessertDao;
    private final MainDishDao mainDishDao;
    private final DrinkDao drinkDao;

    @Override
    public List<MainDish> getAllMainDishes() {
        return mainDishDao.getAll();
    }

    @Override
    public List<Dessert> getAllDeserts() {
        return dessertDao.getAll();
    }

    @Override
    public List<Drink> getAllDrinks() {
        return drinkDao.getAll();
    }
}
