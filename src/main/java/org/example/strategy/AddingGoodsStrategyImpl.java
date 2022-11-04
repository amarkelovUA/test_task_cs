package org.example.strategy;

import java.util.Map;
import org.example.model.Goods;
import org.example.strategy.holder.AddingGoods;

public class AddingGoodsStrategyImpl implements AddingGoodsStrategy {
    private final Map<Class<? extends Goods>, AddingGoods> holders;

    public AddingGoodsStrategyImpl(Map<Class<? extends Goods>, AddingGoods> holders) {
        this.holders = holders;
    }

    @Override
    public AddingGoods addingGoodsHolder(Goods goods) {
        return holders.get(goods.getClass());
    }
}
