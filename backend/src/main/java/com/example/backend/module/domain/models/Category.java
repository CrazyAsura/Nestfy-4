package com.example.backend.module.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category implements ICategory {

    private Long id;
    private String name;
    private Product product;
    
    public Category() {
    }
    
    public Category(Long id, String name, Product product) {
        this.id = id;
        this.name = name;
        this.product = product;
    }
}