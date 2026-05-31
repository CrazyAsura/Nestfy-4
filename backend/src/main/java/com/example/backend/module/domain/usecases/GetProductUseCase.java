package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.Product;
import com.example.backend.module.domain.ports.in.GetProductUseCasePortIn;
import com.example.backend.module.domain.ports.out.IProductRepositoryPortOut;

@Component
public class GetProductUseCase implements GetProductUseCasePortIn{
    private final IProductRepositoryPortOut repositoryPortOut;

    public GetProductUseCase(IProductRepositoryPortOut repositoryPortOut) {
        this.repositoryPortOut = repositoryPortOut;
    }

    @Override
    public Product execute(Long id) {
        return repositoryPortOut.findById(id).orElse(null);
    }
}

