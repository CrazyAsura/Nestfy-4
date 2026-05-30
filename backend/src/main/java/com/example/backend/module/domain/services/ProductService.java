package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.Product;
import com.example.backend.module.domain.ports.out.IProductRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateProductUseCase;
import com.example.backend.module.domain.usecases.DeleteProductUseCase;
import com.example.backend.module.domain.usecases.GetProductUseCase;
import com.example.backend.module.domain.usecases.UpdateProductUseCase;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final CreateProductUseCase createProductUseCase;
    private final GetProductUseCase getProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;

    public ProductService(IProductRepositoryPortOut productRepositoryPortOut) {
        this.createProductUseCase = new CreateProductUseCase(productRepositoryPortOut);
        this.getProductUseCase = new GetProductUseCase(productRepositoryPortOut);
        this.updateProductUseCase = new UpdateProductUseCase(productRepositoryPortOut);
        this.deleteProductUseCase = new DeleteProductUseCase(productRepositoryPortOut);
    }

    public Product createProduct(Product product) {
        return createProductUseCase.execute(product);
    }

    public Product getProduct(Long id) {
        return getProductUseCase.execute(id);
    }

    public Product updateProduct(Product product) {
        return updateProductUseCase.execute(product);
    }

    public void deleteProduct(Long id) {
        deleteProductUseCase.execute(id);
    }
}
