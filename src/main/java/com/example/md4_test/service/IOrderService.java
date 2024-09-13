package com.example.md4_test.service;

import com.example.md4_test.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IOrderService {
    Page<Order> findAll(Pageable pageable);

    Order findById(Long orderId);

    void saveOrder(Order order);

    Order updateOrder(Order existingOrder);

    public Page<Order> findOrdersByDateRange(LocalDateTime startDateTime, LocalDateTime endDateTime, Pageable pageable);


}
