package com.example.md4_test.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id")
    private Long id;

    @Column(name = "product_name")
    private String name;
}
