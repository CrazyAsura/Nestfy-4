package com.example.backend.module.domain.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.adapter.out.persistence.adapters.CategoryPersistenceAdapter;

@Service
public class CategoryService {

    private final CategoryPersistenceAdapter categoryPersistenceAdapter;

    @Autowired
    public CategoryService(CategoryPersistenceAdapter categoryPersistenceAdapter) {
        this.categoryPersistenceAdapter = categoryPersistenceAdapter;
    }

    public Category createCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }
        return categoryPersistenceAdapter.save(category);
    }

    public Category getCategory(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return categoryPersistenceAdapter.findById(id).orElse(null);
    }

    public Category updateCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }
        return categoryPersistenceAdapter.save(category);
    }

    public void deleteCategory(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        categoryPersistenceAdapter.deleteById(id);
    }
    public List<Category> findByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        return categoryPersistenceAdapter.findByName(name);
    }

    public List<Category> findByActive(Boolean active) {
        if (active == null) {
            throw new IllegalArgumentException("active cannot be null");
        }
        return categoryPersistenceAdapter.findByActive(active);
    }
}
