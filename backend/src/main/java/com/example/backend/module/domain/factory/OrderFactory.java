package com.example.backend.module.domain.factory;

import com.example.backend.module.domain.models.Order;
import com.example.backend.module.domain.models.Client;
import com.example.backend.module.domain.models.Product;
import com.example.backend.module.domain.models.Cart;
import com.example.backend.module.domain.factory.interfaces.IOrderFactory;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class OrderFactory implements IOrderFactory {

    @Override
    public Order createOrder(Long id, Client client, List<Product> product, Integer quantity, Double priceWithOutDiscount, Double discountPercentage, Double discountAmount, Double total) {
        return new Order(id, client, product, quantity, priceWithOutDiscount, discountPercentage, discountAmount, total);
    }

    @Override
    public Order createOrderWithCart(Long id, Client client, List<Product> product, Integer quantity, Double priceWithOutDiscount, Double discountPercentage, Double discountAmount, Double total, Cart cart) {
        Order order = new Order(id, client, product, quantity, priceWithOutDiscount, discountPercentage, discountAmount, total);
        order.setCart(cart);
        return order;
    }

    @Override
    public Order createOrderFromProducts(Long id, Client client, List<Product> products, Cart cart) {
        double subtotal = 0.0;
        double discountAmt = 0.0;

        if (products != null) {
            for (Product p : products) {
                subtotal += (p.getUnitPrice() != null ? p.getUnitPrice() : 0.0);
                discountAmt += (p.getDiscountAmount() != null ? p.getDiscountAmount() : 0.0);
            }
        }

        double total = subtotal - discountAmt;
        double discountPercentage = subtotal > 0 ? (discountAmt / subtotal) * 100.0 : 0.0;

        Order order = new Order(id, client, products, products != null ? products.size() : 0, subtotal, discountPercentage, discountAmt, total);
        order.setCart(cart);
        return order;
    }

    @Override
    public Order createEmptyOrder() {
        return new Order();
    }
}
