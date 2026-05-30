package com.example.backend.module.domain.factory;

import com.example.backend.module.domain.models.Category;
import com.example.backend.module.domain.models.Product;
import com.example.backend.module.domain.factory.interfaces.ICategoryFactory;
import org.springframework.stereotype.Component;

@Component
public class CategoryFactory implements ICategoryFactory {

    @Override
    public Category createCategory(Long id, String name, Product product) {
        return new Category(id, name, product);
    }

    @Override
    public Category create() {
        return new Category();
    }
}
