package com.example.backend.module.domain.factory.interfaces;

import com.example.backend.module.domain.models.Product;
import com.example.backend.module.domain.models.Category;

public interface IProductFactory {
    Product createProduct(Long id, String name, String description, String image, Double unitPrice, Double discountPercentage, Double discountAmount, Double finalPrice, Category parent);
    Product createProductWithDiscountCalculation(Long id, String name, String description, String image, Double unitPrice, Double discountPercentage, Category parent);
    Product createEmptyProduct();
}
