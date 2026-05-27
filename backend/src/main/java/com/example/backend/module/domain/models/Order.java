package com.example.backend.module.domain.models;

import java.util.List;

import com.example.backend.module.domain.models.interfaces.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order extends IOrder{

    private Long id;
    private Cart cart;
    private Client client;
    private List<Product> product;
    private Integer quantity;
    private Double priceWithOutDiscount;
    private Double discountPercentage;
    private Double discountAmount;
    private Double total;
    
    public Order(Long id, Client client, List<Product> product, Integer quantity, Double priceWithOutDiscount, Double discountPercentage, Double discountAmount, Double total) {
        this.id = id;
        this.client = client;
        this.product = product;
        this.quantity = quantity;
        this.priceWithOutDiscount = priceWithOutDiscount;
        this.discountPercentage = discountPercentage;
        this.discountAmount = discountAmount;
        this.total = total;
    }

    public Order() {
    }
}