package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.ports.in.DeleteProductUseCasePortIn;
import com.example.backend.module.domain.ports.out.IProductRepositoryPortOut;

public class DeleteProductUseCase implements DeleteProductUseCasePortIn {
    private final IProductRepositoryPortOut productRepositoryPortOut;

    public DeleteProductUseCase(IProductRepositoryPortOut productRepositoryPortOut) {
        this.productRepositoryPortOut = productRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        productRepositoryPortOut.deleteById(id);
    }
}

