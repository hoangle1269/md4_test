package com.example.md4_test.service;

import com.example.md4_test.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderService {
    Page<Order> findAll(Pageable pageable);

    Order findById(Long orderId);

    void saveOrder(Order order);

    Order updateOrder(Order existingOrder);
}
