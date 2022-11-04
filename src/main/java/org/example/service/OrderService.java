package org.example.service;

import org.example.model.Order;

public interface OrderService {
    void makeOrder(Order order);

    void finishOrder(Order order);
}
