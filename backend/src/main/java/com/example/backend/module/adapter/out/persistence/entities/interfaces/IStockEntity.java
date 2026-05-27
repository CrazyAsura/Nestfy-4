package com.example.backend.module.adapter.out.persistence.entities.interfaces;

import lombok.Getter;
import lombok.Setter;
import com.example.backend.module.adapter.out.persistence.entities.*;

@Getter
@Setter
public abstract class IStockEntity {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract ProductEntity getProduct();
    public abstract void setProduct(ProductEntity product);

    public abstract Integer getQuantity();
    public abstract void setQuantity(Integer quantity);
}
