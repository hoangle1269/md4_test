package com.example.md4_test.service;

import com.example.md4_test.model.Order;
import com.example.md4_test.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService{
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public Order findById(Long orderId) {
        return orderRepository.findById(Math.toIntExact(orderId)).orElse(null);
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
