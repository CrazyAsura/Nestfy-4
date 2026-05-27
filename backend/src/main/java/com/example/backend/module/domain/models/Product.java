package com.example.backend.module.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product implements IProduct {
    
    private Long id;
    private String name;
    private String description;
    private String image;
    private Double unitPrice;
    private Double discountPercentage;
    private Double discountAmount;
    private Double finalPrice;
    private Category parent;
    
    public Product() {
    }
    
    public Product(Long id, String name, String description, String image, Double unitPrice, Double discountPercentage, Double discountAmount, Double finalPrice, Category parent) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.parent = parent;
    }
}
