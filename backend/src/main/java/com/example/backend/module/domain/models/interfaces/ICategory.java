package com.example.backend.module.domain.models.interfaces;

import com.example.backend.module.domain.models.*;


public abstract class ICategory {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract String getName();
    public abstract void setName(String name);

    public abstract Product getProduct();
    public abstract void setProduct(Product product);
}