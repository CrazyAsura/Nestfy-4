package com.example.backend.module.domain.models;

import com.example.backend.module.domain.models.interfaces.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem extends ICartItem{

    private Long id;
    private Cart cart;
    private Product product;
    private Integer quantity;
    private Double priceWithOutDiscount;
    private Double discountPercentage;
    private Double discountAmount;
    private Double total;

    public CartItem(Long id, Cart cart, Product product, Integer quantity, Double priceWithOutDiscount, Double discountPercentage, Double discountAmount, Double total) {
        this.id = id;
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
        this.priceWithOutDiscount = priceWithOutDiscount;
        this.discountPercentage = discountPercentage;
        this.discountAmount = discountAmount;
        this.total = total;
    }

    public CartItem() {
    }
}