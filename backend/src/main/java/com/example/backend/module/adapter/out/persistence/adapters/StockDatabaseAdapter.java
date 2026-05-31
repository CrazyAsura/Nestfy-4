package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.adapter.out.persistence.repositories.StockRepository;
import com.example.backend.module.domain.models.Stock;
import com.example.backend.module.domain.ports.out.IStockRepositoryPortOut;

@Component
public class StockDatabaseAdapter implements IStockRepositoryPortOut {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> findByActive(Boolean active) {
        return stockRepository.findByActive(active);
    }

    @Override
    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Optional<Stock> findById(Long id) {
        return stockRepository.findById(id);
    }

    @Override
    public Iterable<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        stockRepository.deleteById(id);
    }

    @Override
    public List<Stock> findByProductId(Long productId) {
        return stockRepository.findByProductId(productId);
    }

    @Override
    public List<Stock> findByStoreId(Long storeId) {
        return stockRepository.findByStoreId(storeId);
    }
}
