package org.example.strategy.holder;

import org.example.model.Goods;
import org.example.model.Order;

@FunctionalInterface
public interface AddingGoods<T extends Goods> {
    void addGoods(Order order, T goods);
}
