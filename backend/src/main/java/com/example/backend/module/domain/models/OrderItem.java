package com.example.backend.module.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItem implements IOrderItem {
    
    private Long id;
    private Order order;
    private Product product;
    private Integer quantity;
    private Double priceWithOutDiscount;
    private Double discountPercentage;
    private Double discountAmount;
    private Double total;
    
    public OrderItem(Long id, Order order, Product product, Integer quantity, Double priceWithOutDiscount, Double discountPercentage, Double discountAmount, Double total) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.priceWithOutDiscount = priceWithOutDiscount;
        this.discountPercentage = discountPercentage;
        this.discountAmount = discountAmount;
        this.total = total;
    }

    public OrderItem() {
    }
}