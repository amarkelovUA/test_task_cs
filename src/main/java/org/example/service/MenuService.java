package org.example.service;

import java.util.List;
import org.example.dao.DessertDao;
import org.example.dao.DrinkDao;
import org.example.dao.MainDishDao;
import org.example.model.Dessert;
import org.example.model.Drink;
import org.example.model.MainDish;

public class MenuService {
    private final DessertDao dessertDao;
    private final MainDishDao mainDishDao;
    private final DrinkDao drinkDao;

    public MenuService(DessertDao dessertDao, MainDishDao mainDishDao, DrinkDao drinkDao) {
        this.dessertDao = dessertDao;
        this.mainDishDao = mainDishDao;
        this.drinkDao = drinkDao;
    }

    public List<MainDish> getAllMainDishes() {
        return mainDishDao.getAll();
    }

    public List<Dessert> getAllDeserts() {
        return dessertDao.getAll();
    }

    public List<Drink> getAllDrinks() {
        return drinkDao.getAll();
    }
}
