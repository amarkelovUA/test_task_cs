package org.example.model;

import java.math.BigDecimal;
import lombok.Data;

@Data
public abstract class Goods {
    private String name;
    private BigDecimal price;

    protected Goods(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
