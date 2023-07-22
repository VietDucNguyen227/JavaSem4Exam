package com.example.javaexamsem4.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer saleNo;

    private Integer saleManId;

    private Date dateOfSale;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
