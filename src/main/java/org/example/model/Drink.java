package org.example.model;

import java.math.BigDecimal;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;

public class Drink extends Goods {
    @Getter
    @Setter
    private Optional<Supplement> supplement;

    public Drink(String name, BigDecimal price, Supplement supplement) {
        super(name, price);
        this.supplement = (supplement == null) ? Optional.empty() : Optional.of(supplement);
    }

    @Override
    public String toString() {
        return "Drink{"
                + "name: " + getName()
                + " price: " + getPrice()
                + '}';
    }
}
