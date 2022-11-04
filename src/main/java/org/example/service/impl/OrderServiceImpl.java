package org.example.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.example.model.Order;
import org.example.service.OrderService;

public class OrderServiceImpl implements OrderService {
    @Override
    public void makeOrder(Order order) {
        BigDecimal totalPrice = order.getDrink().getPrice()
                .add(order.getLunch().getMainDish().getPrice())
                .add(order.getLunch().getDessert().getPrice());

        order.setTotalPrice(totalPrice);
    }

    @Override
    public void finishOrder(Order order) {
        order.setDateTime(LocalDateTime.now());
        order.setPaid(true);
    }
}
