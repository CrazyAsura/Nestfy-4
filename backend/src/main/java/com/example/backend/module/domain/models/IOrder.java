package com.example.backend.module.domain.models;

import java.util.List;

public interface IOrder {
    Long getId();
    void setId(Long id);

    Cart getCart();
    void setCart(Cart cart);

    Client getClient();
    void setClient(Client client);

    List<Product> getProduct();
    void setProduct(List<Product> product);

    Integer getQuantity();
    void setQuantity(Integer quantity);

    Double getPriceWithOutDiscount();
    void setPriceWithOutDiscount(Double priceWithOutDiscount);

    Double getDiscountPercentage();
    void setDiscountPercentage(Double discountPercentage);

    Double getDiscountAmount();
    void setDiscountAmount(Double discountAmount);

    Double getTotal();
    void setTotal(Double total);
}
