package com.example.javaexamsem4.service;

import com.example.javaexamsem4.model.Product;
import com.example.javaexamsem4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        try{
            product.setDateOfManf(new Date());
            return productRepository.save(product);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findAllProduct() {
        try {
            return productRepository.findAll();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}