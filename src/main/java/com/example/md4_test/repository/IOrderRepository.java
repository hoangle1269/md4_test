package com.example.md4_test.repository;

import com.example.md4_test.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {
    Page<Order> findByPurchaseDateBetween(LocalDateTime startDateTime, LocalDateTime endDateTime, Pageable pageable);



}