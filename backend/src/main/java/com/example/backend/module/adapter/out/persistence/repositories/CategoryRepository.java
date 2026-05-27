package com.example.backend.module.adapter.out.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.domain.models.Category;
import com.example.backend.module.domain.models.Product;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    public List<Category> findByName(String name);

    public List<Category> findByProduct(Product product);

    public List<Category> findByActive(Boolean active);
}
