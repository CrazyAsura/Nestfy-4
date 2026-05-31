package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.Product;
import com.example.backend.module.domain.ports.in.CreateProductUseCasePortIn;
import com.example.backend.module.domain.ports.out.IProductRepositoryPortOut;

@Component
public class CreateProductUseCase implements CreateProductUseCasePortIn {
    private final IProductRepositoryPortOut productRepositoryPortOut;

    public CreateProductUseCase(IProductRepositoryPortOut productRepositoryPortOut) {
        this.productRepositoryPortOut = productRepositoryPortOut;
    }

    @Override
    public Product execute(Product product) {
        return productRepositoryPortOut.save(product);
    }
}



