package com.example.backend.module.domain.models;

public interface ICartItem {
    Long getId();
    void setId(Long id);
    Cart getCart();
    void setCart(Cart cart);
    Product getProduct();
    void setProduct(Product product);
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
