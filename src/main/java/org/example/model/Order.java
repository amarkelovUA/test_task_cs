package org.example.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private Lunch lunch;
    private Drink drink;
    private BigDecimal totalPrice;
    private LocalDateTime dateTime;
    private boolean isPaid;

    @Override
    public String toString() {
        String supplementDescription = (drink.getSupplement().isEmpty()) ? "none"
                : drink.getSupplement().get().getDescription();
        return "Order: " + System.lineSeparator()
                + "  for lunch: " + System.lineSeparator()
                + "    - " + lunch.getMainDish() + System.lineSeparator()
                + "    - " + lunch.getDessert() + System.lineSeparator()
                + "  and drink: " + System.lineSeparator()
                + "    - " + drink + System.lineSeparator()
                + "    - supplement to drink: " + supplementDescription + System.lineSeparator()
                + "Total price: " + totalPrice + "UAH";
    }
}
