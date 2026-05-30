package com.example.backend.module.domain.ports.out;

import java.util.List;

import com.example.backend.module.domain.models.Stock;

public interface IStockRepositoryPortOut extends IRepositoryPortOut<Stock, Long> {

    public List<Stock> findByProductId(Long productId);

    public List<Stock> findByActive(Boolean active);

    public List<Stock> findByStoreId(Long storeId);
}

