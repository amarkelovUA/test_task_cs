package org.example.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

public class Drink extends Goods {
    @Getter
    @Setter
    private Supplement supplement;

    protected Drink(String name, BigDecimal price, Supplement supplement) {
        super(name, price);
        this.supplement = supplement;
    }
}
