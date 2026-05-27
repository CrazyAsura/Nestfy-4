package com.example.backend.module.adapter.out.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.domain.models.Product;
import com.example.backend.module.domain.models.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    public List<Stock> findByProduct(Product product);
}
