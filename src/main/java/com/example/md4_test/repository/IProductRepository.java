package com.example.md4_test.repository;

import com.example.md4_test.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductTypeId(Long typeId);
}
