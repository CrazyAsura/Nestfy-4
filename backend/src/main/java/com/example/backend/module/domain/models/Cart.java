package com.example.backend.module.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart implements ICart {

    private Long id;
    private User user;
    private Product product;
    private Integer quantity;
    private Double priceWithOutDiscount;
    private Double discountPercentage;
    private Double discountAmount;
    private Double total;

    public Cart(Long id, User user, Product product, Integer quantity, Double priceWithOutDiscount, Double discountPercentage, Double discountAmount, Double total) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.priceWithOutDiscount = priceWithOutDiscount;
        this.discountPercentage = discountPercentage;
        this.discountAmount = discountAmount;
        this.total = total;
    }

    public Cart() {
    }
}
