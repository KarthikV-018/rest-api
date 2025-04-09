package com.example.gardening_api.service;

import com.example.gardening_api.model.Order;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order saveOrder(Order order);
    Optional<Order> getOrderById(Long id);
    List<Order> getAllOrders();
    Order updateOrder(Long id, Order order); 
    void deleteOrder(Long id);
}
