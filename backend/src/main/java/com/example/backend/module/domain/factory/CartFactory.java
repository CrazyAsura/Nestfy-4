package com.example.backend.module.domain.factory;

import com.example.backend.module.domain.models.Cart;
import com.example.backend.module.domain.models.User;
import com.example.backend.module.domain.models.Product;
import com.example.backend.module.domain.factory.interfaces.ICartFactory;
import org.springframework.stereotype.Component;

@Component
public class CartFactory implements ICartFactory {

    @Override
    public Cart createCart(Long id, User user, Product product, Integer quantity, Double priceWithOutDiscount, Double discountPercentage, Double discountAmount, Double total) {
        return new Cart(id, user, product, quantity, priceWithOutDiscount, discountPercentage, discountAmount, total);
    }
}
