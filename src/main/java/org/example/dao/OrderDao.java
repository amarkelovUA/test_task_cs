package org.example.dao;

import java.time.LocalDate;
import java.util.List;
import org.example.model.Order;

public interface OrderDao extends GenericDao<Order> {
    List<Order> getAllByDay(LocalDate date);
}
