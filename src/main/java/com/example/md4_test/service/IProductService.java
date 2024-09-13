package com.example.md4_test.service;


import com.example.md4_test.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface IProductService {
    List<Product> findAll();

}
