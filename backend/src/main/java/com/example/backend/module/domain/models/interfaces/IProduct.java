package com.example.backend.module.domain.models.interfaces;

import com.example.backend.module.domain.models.*;


public abstract class IProduct {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract String getName();
    public abstract void setName(String name);

    public abstract String getDescription();
    public abstract void setDescription(String description);

    public abstract String getImage();
    public abstract void setImage(String image);

    public abstract Double getUnitPrice();
    public abstract void setUnitPrice(Double unitPrice);

    public abstract Double getDiscountPercentage();
    public abstract void setDiscountPercentage(Double discountPercentage);

    public abstract Double getDiscountAmount();
    public abstract void setDiscountAmount(Double discountAmount);

    public abstract Double getFinalPrice();
    public abstract void setFinalPrice(Double finalPrice);

    public abstract Category getParent();
    public abstract void setParent(Category parent);
}