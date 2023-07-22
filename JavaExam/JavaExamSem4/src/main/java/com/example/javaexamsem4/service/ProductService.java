package com.example.javaexamsem4.service;

import com.example.javaexamsem4.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> findAllProduct();
}
