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

    public void makeOrder() {
        totalPrice = drink.getPrice()
                .add(lunch.getMainDish().getPrice())
                .add(lunch.getDessert().getPrice());
    }

    public void finishOrder() {
        dateTime = LocalDateTime.now();
        isPaid = true;
    }

    @Override
    public String toString() {
        return "Order: " + System.lineSeparator()
                + "  for lunch: " + System.lineSeparator()
                + "    - " + lunch.getMainDish() + System.lineSeparator()
                + "    - " + lunch.getDessert() + System.lineSeparator()
                + "  and drink: " + System.lineSeparator()
                + "    - " + drink + System.lineSeparator()
                + "    - supplement to drink: " + drink.getSupplement().getDescription()
                + "Total price: " + totalPrice + "UAH";
    }
}
