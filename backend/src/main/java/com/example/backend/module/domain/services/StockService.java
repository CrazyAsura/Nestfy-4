package com.example.backend.module.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.adapter.out.persistence.adapters.StockPersistenceAdapter;
import com.example.backend.module.domain.models.Stock;

@Service
public class StockService {

    private final StockPersistenceAdapter stockPersistenceAdapter;

    @Autowired
    public StockService(StockPersistenceAdapter stockPersistenceAdapter) {
        this.stockPersistenceAdapter = stockPersistenceAdapter;
    }

    public Stock createStock(Stock stock) {
        if (stock == null) {
            throw new IllegalArgumentException("Stock cannot be null");
        }
        return stockPersistenceAdapter.save(stock);
    }

    public Stock getStock(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return stockPersistenceAdapter.findById(id).orElse(null);
    }

    public Stock updateStock(Stock stock) {
        if (stock == null) {
            throw new IllegalArgumentException("Stock cannot be null");
        }
        return stockPersistenceAdapter.save(stock);
    }

    public void deleteStock(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        stockPersistenceAdapter.deleteById(id);
    }

    public List<Stock> findByProductId(Long productId) {
        if (productId == null) {
            throw new IllegalArgumentException("productId cannot be null");
        }
        return stockPersistenceAdapter.findByProductId(productId);
    }

    public List<Stock> findByActive(Boolean active) {
        if (active == null) {
            throw new IllegalArgumentException("active cannot be null");
        }
        return stockPersistenceAdapter.findByActive(active);
    }

    public List<Stock> findByStoreId(Long storeId) {
        if (storeId == null) {
            throw new IllegalArgumentException("storeId cannot be null");
        }
        return stockPersistenceAdapter.findByStoreId(storeId);
    }
}
