package com.example.backend.module.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stock implements IStock {
    
    private Long id;
    private Product product;
    private Integer quantity;
    
    public Stock() {
    }
    
    public Stock(Long id, Product product, Integer quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }
}