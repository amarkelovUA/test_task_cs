package org.example.strategy.parser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.example.model.Drink;
import org.example.model.Supplement;

public class DrinkParserImpl implements ParserGoods<Drink> {
    private static final int NAME_INDEX = 0;
    private static final int PRICE_INDEX = 1;
    private static final int SUPPLEMENT_INDEX = 2;

    @Override
    public List<Drink> parse(List<String[]> input) {
        List<Drink> drinks = new ArrayList<>();
        if (input != null) {
            for (String[] row : input) {
                Optional<Supplement> optionalSupplement = Arrays.stream(Supplement.values())
                        .filter(s -> s.getDescription().equals(row[SUPPLEMENT_INDEX]))
                        .findFirst();
                Drink drink = new Drink(
                        row[NAME_INDEX],
                        BigDecimal.valueOf(Double.parseDouble(row[PRICE_INDEX])),
                        optionalSupplement.orElse(null)
                );
                drinks.add(drink);
            }
        }
        return drinks;
    }
}
