package org.example.strategy.holder;

import org.example.model.Dessert;
import org.example.model.Lunch;
import org.example.model.Order;

public class AddingDesserts implements AddingGoods<Dessert> {
    @Override
    public void addGoods(Order order, Dessert dessert) {
        if (order.getLunch() == null) {
            order.setLunch(new Lunch());
        }
        order.getLunch().setDessert(dessert);
    }
}
