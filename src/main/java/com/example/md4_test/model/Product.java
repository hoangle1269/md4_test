package com.example.md4_test.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private Double price;

    @Column(name = "product_status")
    private String productStatus;

    @ManyToOne
    @JoinColumn(name = "product_type")
    private ProductType productType;
}
