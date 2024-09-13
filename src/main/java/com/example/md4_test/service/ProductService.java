package com.example.md4_test.service;

import com.example.md4_test.model.Product;
import com.example.md4_test.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByProductTypeId(Long id) {
        return productRepository.findByProductTypeId(id);
    }
}
