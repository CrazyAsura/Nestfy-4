package com.example.backend.module.domain.models;

public interface ICategory {
    Long getId();
    void setId(Long id);

    String getName();
    void setName(String name);

    Product getProduct();
    void setProduct(Product product);
}
