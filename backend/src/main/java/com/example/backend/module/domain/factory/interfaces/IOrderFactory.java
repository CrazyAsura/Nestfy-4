package com.example.backend.module.domain.factory.interfaces;

import com.example.backend.module.domain.models.Order;
import com.example.backend.module.domain.models.Client;
import com.example.backend.module.domain.models.Product;
import com.example.backend.module.domain.models.Cart;
import java.util.List;

public interface IOrderFactory {
    Order createOrder(Long id, Client client, List<Product> product, Integer quantity, Double priceWithOutDiscount, Double discountPercentage, Double discountAmount, Double total);
    Order createOrderWithCart(Long id, Client client, List<Product> product, Integer quantity, Double priceWithOutDiscount, Double discountPercentage, Double discountAmount, Double total, Cart cart);
    Order createOrderFromProducts(Long id, Client client, List<Product> products, Cart cart);
    Order createEmptyOrder();
}
