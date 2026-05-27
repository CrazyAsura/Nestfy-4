package com.example.backend.module.domain.models;

public interface IOrderItem {
    Long getId();
    void setId(Long id);

    Order getOrder();
    void setOrder(Order order);

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
