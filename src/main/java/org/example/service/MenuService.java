package org.example.service;

import java.util.List;
import org.example.model.Dessert;
import org.example.model.Drink;
import org.example.model.MainDish;

public interface MenuService {
    List<MainDish> getAllMainDishes();

    List<Dessert> getAllDeserts();

    List<Drink> getAllDrinks();
}
