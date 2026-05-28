package com.example.backend.module.domain.ports.out;

import java.util.List;

import com.example.backend.module.domain.models.Product;

public interface ProductRepositoryPortOut extends IRepositoryPortOut<Product, Long> {

    public List<Product> findByName(String name);

    public List<Product> findByPrice(Double price);

    public List<Product> findByDescription(String description);

    public List<Product> findByCategory(String category);

    public List<Product> findBySupplier(String supplier);

    public List<Product> findByActive(Boolean active);

}
