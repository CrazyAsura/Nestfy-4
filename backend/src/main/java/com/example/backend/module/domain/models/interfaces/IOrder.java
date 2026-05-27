package com.example.backend.module.domain.models.interfaces;
    
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class IOrder {

    private Long id;
    private Long userId;
    private Long clientId;
    private Long productId;
    private Integer quantity;
    private Double priceWithOutDiscount;
    private Double discountPercentage;
    private Double discountAmount;
    private Double total;
}