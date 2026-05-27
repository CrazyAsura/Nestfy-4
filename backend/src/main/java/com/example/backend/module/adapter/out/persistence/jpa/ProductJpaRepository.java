package com.example.backend.module.adapter.out.persistence.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.adapter.out.persistence.entities.CategoryJpaEntity;
import com.example.backend.module.adapter.out.persistence.entities.ProductJpaEntity;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductJpaEntity, Long> {

    public List<ProductJpaEntity> findByName(String name);

    public List<ProductJpaEntity> findByPrice(Double price);

    public List<ProductJpaEntity> findByDescription(String description);

    public List<ProductJpaEntity> findByCategory(CategoryJpaEntity category);

    public List<ProductJpaEntity> findBySupplier(String supplier);

    public List<ProductJpaEntity> findByActive(Boolean active);

}
