package org.example.service;

import org.example.model.Dessert;
import org.example.model.Drink;
import org.example.model.MainDish;

import java.util.List;

public interface MenuService {
    List<MainDish> getAllMainDishes();

    List<Dessert> getAllDeserts();

    List<Drink> getAllDrinks();
}
