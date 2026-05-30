package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.ports.in.DeleteStockUseCasePortIn;
import com.example.backend.module.domain.ports.out.IStockRepositoryPortOut;

public class DeleteStockUseCase implements DeleteStockUseCasePortIn {
    private final IStockRepositoryPortOut stockRepositoryPortOut;

    public DeleteStockUseCase(IStockRepositoryPortOut stockRepositoryPortOut) {
        this.stockRepositoryPortOut = stockRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        stockRepositoryPortOut.deleteById(id);
    }
}

