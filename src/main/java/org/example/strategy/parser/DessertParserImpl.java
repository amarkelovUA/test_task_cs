package org.example.strategy.parser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.example.model.Cuisine;
import org.example.model.Dessert;

public class DessertParserImpl implements ParserGoods<Dessert> {
    private static final int NAME_INDEX = 0;
    private static final int PRICE_INDEX = 1;
    private static final int CUISINE_INDEX = 2;

    @Override
    public List<Dessert> parse(List<String[]> input) {
        List<Dessert> desserts = new ArrayList<>();
        if (input != null) {
            for (String[] row : input) {
                Optional<Cuisine> cuisineOptional = Arrays.stream(Cuisine.values())
                        .filter(c -> c.getDescription().equals(row[CUISINE_INDEX]))
                        .findFirst();
                Dessert dessert = new Dessert(
                        row[NAME_INDEX],
                        BigDecimal.valueOf(Double.parseDouble(row[PRICE_INDEX])),
                        cuisineOptional.orElse(null)
                );
                desserts.add(dessert);
            }
        }
        return desserts;
    }
}
