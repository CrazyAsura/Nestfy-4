package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.Stock;
import com.example.backend.module.domain.ports.in.UpdateStockUseCasePortIn;
import com.example.backend.module.domain.ports.out.IStockRepositoryPortOut;

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

