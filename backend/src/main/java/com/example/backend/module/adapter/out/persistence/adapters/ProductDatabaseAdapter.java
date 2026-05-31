package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.Product;
import com.example.backend.module.domain.ports.out.IProductRepositoryPortOut;

@Component
public class ProductDatabaseAdapter implements IProductRepositoryPortOut {

    private final Map<Long, Product> memoryDatabase = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public ProductDatabaseAdapter() {

    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(memoryDatabase.get(id));
    }

    @Override
    public Iterable<Product> findAll() {
        return new ArrayList<>(memoryDatabase.values());
    }

    @Override
    public Product save(Product entity) {
        if (entity.getId() == null) {
            entity.setId(idGenerator.getAndIncrement());
        }
        memoryDatabase.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public void deleteById(Long id) {
        memoryDatabase.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return memoryDatabase.values().stream()
                .filter(p -> p.getName() != null && p.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByPrice(Double price) {
        return memoryDatabase.values().stream()
                .filter(p -> p.getUnitPrice() != null && p.getUnitPrice().equals(price))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByDescription(String description) {
        return memoryDatabase.values().stream()
                .filter(p -> p.getDescription() != null && p.getDescription().toLowerCase().contains(description.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByCategory(String categoryName) {
        return memoryDatabase.values().stream()
                .filter(p -> p.getParent() != null && p.getParent().getName().toLowerCase().contains(categoryName.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findBySupplier(String supplier) {
        // Mocked supplier mapping
        return new ArrayList<>();
    }

    @Override
    public List<Product> findByActive(Boolean active) {
        // Mocked active status mapping
        return new ArrayList<>(memoryDatabase.values());
    }
}
