package org.example.strategy;

import java.util.Map;
import org.example.model.Dessert;
import org.example.model.Drink;
import org.example.model.Goods;
import org.example.model.MainDish;
import org.example.strategy.holder.AddingDesserts;
import org.example.strategy.holder.AddingDrink;
import org.example.strategy.holder.AddingGoods;
import org.example.strategy.holder.AddingMainDish;

public class AddingGoodsStrategyImpl implements AddingGoodsStrategy {
    private final Map<Class<? extends Goods>, AddingGoods> holders;

    public AddingGoodsStrategyImpl() {
        holders = Map.of(
                Drink.class, new AddingDrink(),
                Dessert.class, new AddingDesserts(),
                MainDish.class, new AddingMainDish()
        );
    }

    @Override
    public AddingGoods addingGoodsHolder(Goods goods) {
        return holders.get(goods.getClass());
    }
}
