package org.example.model;

import java.math.BigDecimal;
import lombok.Getter;

public class MainDish extends Goods {
    @Getter
    private final Cuisine cuisine;

    public MainDish(String name, BigDecimal price, Cuisine cuisine) {
        super(name, price);
        this.cuisine = cuisine;
    }
}
