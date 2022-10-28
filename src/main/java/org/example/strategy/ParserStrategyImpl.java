package org.example.strategy;

import java.util.Map;
import org.example.model.Dessert;
import org.example.model.Drink;
import org.example.model.MainDish;
import org.example.strategy.parser.DessertParserImpl;
import org.example.strategy.parser.DrinkParserImpl;
import org.example.strategy.parser.MainDishParserImpl;
import org.example.strategy.parser.ParserGoods;

public class ParserStrategyImpl implements ParserStrategy {
    private final Map<?, ParserGoods<?>> parserMap;

    public ParserStrategyImpl() {
        parserMap = Map.of(
                Drink.class, new DrinkParserImpl(),
                MainDish.class, new MainDishParserImpl(),
                Dessert.class, new DessertParserImpl()
        );
    }

    @Override
    public ParserGoods<?> getParser(Class clazz) {
        return parserMap.get(clazz);
    }
}
