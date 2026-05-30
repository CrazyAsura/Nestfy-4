package com.example.backend.module.domain.factory.interfaces;

import com.example.backend.module.domain.models.Category;
import com.example.backend.module.domain.models.Product;

public interface ICategoryFactory {
    Category createCategory(Long id, String name, Product product);
    Category create();
}
