package com.example.servingwebcontent.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nameProduct;

    @ManyToOne
    @JoinColumn(name = "stock_id", referencedColumnName = "id", nullable = false)
    private Stock stock;

    @Column(nullable = false)
    private Integer amountOnStock;
    @Column(nullable = false)
    private Integer amountOnSale;
    @Column(nullable = false)
    private Float priceProduct;
}
