package com.example.backend.module.domain.models.interfaces;

import com.example.backend.module.domain.models.*;


public abstract class IOrderItem {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract Order getOrder();
    public abstract void setOrder(Order order);

    public abstract Product getProduct();
    public abstract void setProduct(Product product);

    public abstract Integer getQuantity();
    public abstract void setQuantity(Integer quantity);

    public abstract Double getPriceWithOutDiscount();
    public abstract void setPriceWithOutDiscount(Double priceWithOutDiscount);

    public abstract Double getDiscountPercentage();
    public abstract void setDiscountPercentage(Double discountPercentage);

    public abstract Double getDiscountAmount();
    public abstract void setDiscountAmount(Double discountAmount);

    public abstract Double getTotal();
    public abstract void setTotal(Double total);
}