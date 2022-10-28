package org.example.strategy.holder;

import org.example.model.Dessert;
import org.example.model.Goods;
import org.example.model.Lunch;
import org.example.model.Order;

public class AddingDesserts implements AddingGoods {
    @Override
    public void addGoods(Order order, Goods goods) {
        if (order.getLunch() == null) {
            order.setLunch(new Lunch());
        }
        order.getLunch().setDessert((Dessert) goods);
    }
}
