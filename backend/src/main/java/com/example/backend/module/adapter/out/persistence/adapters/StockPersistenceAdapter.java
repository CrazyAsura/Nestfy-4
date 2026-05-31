package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.Stock;
import com.example.backend.module.domain.ports.out.IStockRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateStockUseCase;
import com.example.backend.module.domain.usecases.DeleteStockUseCase;
import com.example.backend.module.domain.usecases.GetStockUseCase;
import com.example.backend.module.domain.usecases.UpdateStockUseCase;

@Component
public class StockPersistenceAdapter {

    private final CreateStockUseCase createStockUseCase;
    private final GetStockUseCase getStockUseCase;
    private final UpdateStockUseCase updateStockUseCase;
    private final DeleteStockUseCase deleteStockUseCase;
    private final IStockRepositoryPortOut stockRepositoryPortOut;

    @Autowired
    public StockPersistenceAdapter(CreateStockUseCase createStockUseCase,
            GetStockUseCase getStockUseCase,
            UpdateStockUseCase updateStockUseCase,
            DeleteStockUseCase deleteStockUseCase,
            IStockRepositoryPortOut stockRepositoryPortOut) {
        this.createStockUseCase = createStockUseCase;
        this.getStockUseCase = getStockUseCase;
        this.updateStockUseCase = updateStockUseCase;
        this.deleteStockUseCase = deleteStockUseCase;
        this.stockRepositoryPortOut = stockRepositoryPortOut;
    }

    public Optional<Stock> findById(Long id) {
        return Optional.ofNullable(getStockUseCase.execute(id));
    }

    public Iterable<Stock> findAll() {
        return stockRepositoryPortOut.findAll();
    }

    public Stock save(Stock entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createStockUseCase.execute(entity);
        } else {
            return updateStockUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deleteStockUseCase.execute(id);
    }

    public List<Stock> findByProductId(Long productId) {
        return stockRepositoryPortOut.findByProductId(productId);
    }

    public List<Stock> findByActive(Boolean active) {
        return stockRepositoryPortOut.findByActive(active);
    }

    public List<Stock> findByStoreId(Long storeId) {
        return stockRepositoryPortOut.findByStoreId(storeId);
    }
}
