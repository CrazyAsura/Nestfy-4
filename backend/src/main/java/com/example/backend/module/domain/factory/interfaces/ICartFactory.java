package com.example.backend.module.domain.factory.interfaces;

import com.example.backend.module.domain.models.Cart;
import com.example.backend.module.domain.models.User;
import com.example.backend.module.domain.models.Product;

public interface ICartFactory {
    Cart createCart(Long id, User user, Product product, Integer quantity, Double priceWithOutDiscount, Double discountPercentage, Double discountAmount, Double total);
}
