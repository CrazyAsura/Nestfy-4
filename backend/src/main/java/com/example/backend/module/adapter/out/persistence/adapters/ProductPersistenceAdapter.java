package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.Product;
import com.example.backend.module.domain.ports.out.IProductRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateProductUseCase;
import com.example.backend.module.domain.usecases.DeleteProductUseCase;
import com.example.backend.module.domain.usecases.GetProductUseCase;
import com.example.backend.module.domain.usecases.UpdateProductUseCase;

@Component
public class ProductPersistenceAdapter {

    private final CreateProductUseCase createProductUseCase;
    private final GetProductUseCase getProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final IProductRepositoryPortOut productRepositoryPortOut;

    @Autowired
    public ProductPersistenceAdapter(CreateProductUseCase createProductUseCase,
            GetProductUseCase getProductUseCase,
            UpdateProductUseCase updateProductUseCase,
            DeleteProductUseCase deleteProductUseCase,
            IProductRepositoryPortOut productRepositoryPortOut) {
        this.createProductUseCase = createProductUseCase;
        this.getProductUseCase = getProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
        this.productRepositoryPortOut = productRepositoryPortOut;
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(getProductUseCase.execute(id));
    }

    public Iterable<Product> findAll() {
        return productRepositoryPortOut.findAll();
    }

    public Product save(Product entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createProductUseCase.execute(entity);
        } else {
            return updateProductUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deleteProductUseCase.execute(id);
    }

    public List<Product> findByName(String name) {
        return productRepositoryPortOut.findByName(name);
    }

    public List<Product> findByPrice(Double price) {
        return productRepositoryPortOut.findByPrice(price);
    }

    public List<Product> findByDescription(String description) {
        return productRepositoryPortOut.findByDescription(description);
    }

    public List<Product> findByCategory(String category) {
        return productRepositoryPortOut.findByCategory(category);
    }

    public List<Product> findBySupplier(String supplier) {
        return productRepositoryPortOut.findBySupplier(supplier);
    }

    public List<Product> findByActive(Boolean active) {
        return productRepositoryPortOut.findByActive(active);
    }
}
