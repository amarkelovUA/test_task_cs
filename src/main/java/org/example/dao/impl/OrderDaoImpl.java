package org.example.dao.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.example.dao.AbstractDao;
import org.example.dao.OrderDao;
import org.example.model.Order;

public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {
    public OrderDaoImpl(List<Order> database) {
        super(database);
    }

    @Override
    public List<Order> getAllByDay(LocalDate date) {
        return database.stream()
                .filter(order -> order.getDateTime().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }
}
