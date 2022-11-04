package org.example.strategy.holder;

import org.example.model.Lunch;
import org.example.model.MainDish;
import org.example.model.Order;

public class AddingMainDish implements AddingGoods<MainDish> {
    @Override
    public void addGoods(Order order, MainDish mainDish) {
        if (order.getLunch() == null) {
            order.setLunch(new Lunch());
        }
        order.getLunch().setMainDish(mainDish);
    }
}
