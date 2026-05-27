package com.example.backend.module.adapter.out.persistence.entities.interfaces;

import lombok.Getter;
import lombok.Setter;
import com.example.backend.module.adapter.out.persistence.entities.*;

@Getter
@Setter
public abstract class ICartEntity {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract UserEntity getUser();
    public abstract void setUser(UserEntity user);

    public abstract ProductEntity getProduct();
    public abstract void setProduct(ProductEntity product);

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
