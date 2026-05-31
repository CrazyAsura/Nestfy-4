package com.example.backend.module.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.adapter.out.persistence.adapters.ProductPersistenceAdapter;
import com.example.backend.module.domain.models.Product;

@Service
public class ProductService {

    private final ProductPersistenceAdapter productPersistenceAdapter;

    @Autowired
    public ProductService(ProductPersistenceAdapter productPersistenceAdapter) {
        this.productPersistenceAdapter = productPersistenceAdapter;
    }

    public Product createProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        return productPersistenceAdapter.save(product);
    }

    public Product getProduct(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return productPersistenceAdapter.findById(id).orElse(null);
    }

    public Product updateProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        return productPersistenceAdapter.save(product);
    }

    public void deleteProduct(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        productPersistenceAdapter.deleteById(id);
    }

    public List<Product> findByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        return productPersistenceAdapter.findByName(name);
    }

    public List<Product> findByPrice(Double price) {
        if (price == null) {
            throw new IllegalArgumentException("price cannot be null");
        }
        return productPersistenceAdapter.findByPrice(price);
    }

    public List<Product> findByDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException("description cannot be null");
        }
        return productPersistenceAdapter.findByDescription(description);
    }

    public List<Product> findByCategory(String category) {
        if (category == null) {
            throw new IllegalArgumentException("category cannot be null");
        }
        return productPersistenceAdapter.findByCategory(category);
    }

    public List<Product> findBySupplier(String supplier) {
        if (supplier == null) {
            throw new IllegalArgumentException("supplier cannot be null");
        }
        return productPersistenceAdapter.findBySupplier(supplier);
    }

    public List<Product> findByActive(Boolean active) {
        if (active == null) {
            throw new IllegalArgumentException("active cannot be null");
        }
        return productPersistenceAdapter.findByActive(active);
    }
}
