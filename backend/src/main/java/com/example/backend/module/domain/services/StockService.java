package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.Stock;
import com.example.backend.module.domain.ports.out.IStockRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateStockUseCase;
import com.example.backend.module.domain.usecases.DeleteStockUseCase;
import com.example.backend.module.domain.usecases.GetStockUseCase;
import com.example.backend.module.domain.usecases.UpdateStockUseCase;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    private final CreateStockUseCase createStockUseCase;
    private final GetStockUseCase getStockUseCase;
    private final UpdateStockUseCase updateStockUseCase;
    private final DeleteStockUseCase deleteStockUseCase;

    public StockService(IStockRepositoryPortOut stockRepositoryPortOut) {
        this.createStockUseCase = new CreateStockUseCase(stockRepositoryPortOut);
        this.getStockUseCase = new GetStockUseCase(stockRepositoryPortOut);
        this.updateStockUseCase = new UpdateStockUseCase(stockRepositoryPortOut);
        this.deleteStockUseCase = new DeleteStockUseCase(stockRepositoryPortOut);
    }

    public Stock createStock(Stock stock) {
        return createStockUseCase.execute(stock);
    }

    public Stock getStock(Long id) {
        return getStockUseCase.execute(id);
    }

    public Stock updateStock(Stock stock) {
        return updateStockUseCase.execute(stock);
    }

    public void deleteStock(Long id) {
        deleteStockUseCase.execute(id);
    }
}
