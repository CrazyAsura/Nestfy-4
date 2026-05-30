package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.Stock;
import com.example.backend.module.domain.ports.in.GetStockUseCasePortIn;
import com.example.backend.module.domain.ports.out.IStockRepositoryPortOut;

public class GetStockUseCase implements GetStockUseCasePortIn {
    private final IStockRepositoryPortOut stockRepositoryPortOut;

    public GetStockUseCase(IStockRepositoryPortOut stockRepositoryPortOut) {
        this.stockRepositoryPortOut = stockRepositoryPortOut;
    }

    @Override
    public Stock execute(Long id) {
        return stockRepositoryPortOut.findById(id).orElse(null);
    }
}

