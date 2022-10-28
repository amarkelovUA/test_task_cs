package org.example.strategy;

import org.example.model.Goods;
import org.example.strategy.holder.AddingGoods;

public interface AddingGoodsStrategy {
    AddingGoods addingGoodsHolder(Goods goods);
}
