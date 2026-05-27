package com.example.backend.module.adapter.out.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.domain.models.Category;
import com.example.backend.module.domain.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByName(String name);

    public List<Product> findByPrice(Double price);

    public List<Product> findByDescription(String description);

    public List<Product> findByCategory(Category category);

    public List<Product> findBySupplier(String supplier);

    public List<Product> findByActive(Boolean active);

}
