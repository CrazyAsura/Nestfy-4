package com.example.backend.module.domain.models.interfaces;

import com.example.backend.module.domain.models.*;


public abstract class IStock {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract Product getProduct();
    public abstract void setProduct(Product product);

    public abstract Integer getQuantity();
    public abstract void setQuantity(Integer quantity);
}