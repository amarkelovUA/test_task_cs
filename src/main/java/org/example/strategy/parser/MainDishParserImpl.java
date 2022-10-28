package org.example.strategy.parser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.example.model.Cuisine;
import org.example.model.MainDish;

public class MainDishParserImpl implements ParserGoods<MainDish> {
    private static final int NAME_INDEX = 0;
    private static final int PRICE_INDEX = 1;
    private static final int CUISINE_INDEX = 2;

    @Override
    public List<MainDish> parse(List<String[]> input) {
        List<MainDish> mainDishes = new ArrayList<>();
        if (input != null) {
            for (String[] row : input) {
                Optional<Cuisine> optionalCuisine = Arrays.stream(Cuisine.values())
                        .filter(c -> c.getDescription().equals(row[CUISINE_INDEX]))
                        .findFirst();
                MainDish mainDish = new MainDish(
                        row[NAME_INDEX],
                        BigDecimal.valueOf(Double.parseDouble(row[PRICE_INDEX])),
                        optionalCuisine.orElse(null)
                );
                mainDishes.add(mainDish);
            }
        }
        return mainDishes;
    }
}
