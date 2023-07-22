package com.example.javaexamsem4.model;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer productId;

    private String productName;

    private String description;

    private Date dateOfManf;

    private Double price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Sale> sales;
}
