package com.example.backend.module.adapter.out.persistence.entities.interfaces;

import lombok.Getter;
import lombok.Setter;
import com.example.backend.module.adapter.out.persistence.entities.*;

@Getter
@Setter
public abstract class IProductEntity {

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

    public abstract CategoryEntity getParent();
    public abstract void setParent(CategoryEntity parent);
}
