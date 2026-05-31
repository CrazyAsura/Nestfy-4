package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.Stock;
import com.example.backend.module.domain.ports.in.UpdateStockUseCasePortIn;
import com.example.backend.module.domain.ports.out.IStockRepositoryPortOut;

@Component
public class UpdateStockUseCase implements UpdateStockUseCasePortIn {
    private final IStockRepositoryPortOut stockRepositoryPortOut;

    public UpdateStockUseCase(IStockRepositoryPortOut stockRepositoryPortOut) {
        this.stockRepositoryPortOut = stockRepositoryPortOut;
    }

    @Override
    public Stock execute(Stock stock) {
        return stockRepositoryPortOut.save(stock);
    }
}

