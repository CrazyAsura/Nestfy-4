package com.example.backend.module.domain.factory;

import com.example.backend.module.domain.models.Product;
import com.example.backend.module.domain.models.Category;
import com.example.backend.module.domain.factory.interfaces.IProductFactory;
import org.springframework.stereotype.Component;

@Component
public class ProductFactory implements IProductFactory {

    @Override
    public Product createProduct(Long id, String name, String description, String image, Double unitPrice, Double discountPercentage, Double discountAmount, Double finalPrice, Category parent) {
        Product product = new Product(id, name, description, image, unitPrice, discountPercentage, discountAmount, finalPrice, parent);
        product.setUnitPrice(unitPrice);
        product.setDiscountPercentage(discountPercentage);
        product.setDiscountAmount(discountAmount);
        product.setFinalPrice(finalPrice);
        return product;
    }

    @Override
    public Product createProductWithDiscountCalculation(Long id, String name, String description, String image, Double unitPrice, Double discountPercentage, Category parent) {
        double discountPct = discountPercentage != null ? discountPercentage : 0.0;
        double price = unitPrice != null ? unitPrice : 0.0;
        double discountAmt = price * (discountPct / 100.0);
        double finalPrice = price - discountAmt;

        Product product = new Product(id, name, description, image, price, discountPct, discountAmt, finalPrice, parent);
        product.setUnitPrice(price);
        product.setDiscountPercentage(discountPct);
        product.setDiscountAmount(discountAmt);
        product.setFinalPrice(finalPrice);
        return product;
    }

    @Override
    public Product createEmptyProduct() {
        return new Product();
    }
}
