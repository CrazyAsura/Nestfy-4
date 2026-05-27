package com.example.backend.module.domain.models;

public interface IStock {
    Long getId();
    void setId(Long id);

    Product getProduct();
    void setProduct(Product product);

    Integer getQuantity();
    void setQuantity(Integer quantity);
}
