package org.example.strategy.holder;

import org.example.model.Goods;
import org.example.model.Order;

@FunctionalInterface
public interface AddingGoods {
    void addGoods(Order order, Goods goods);
}
