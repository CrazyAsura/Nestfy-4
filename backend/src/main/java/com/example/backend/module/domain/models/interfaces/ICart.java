package com.example.backend.module.domain.models.interfaces;

import com.example.backend.module.domain.models.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ICart {

    private Long id;
    private User user;
    private Product product;
    private Integer quantity;
    private Double priceWithOutDiscount;
    private Double discountPercentage;
    private Double discountAmount;
    private Double total;

}