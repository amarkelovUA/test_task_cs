package org.example.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class Order {
    private Long id;
    private List<Launch> launches;
    private List<Drink> drinks;
    private BigDecimal totalPrice;
    private LocalDateTime dateTime;
    private boolean isPaid;

    public void makeOrder() {

    }

    public void finishOrder() {

    }
}
