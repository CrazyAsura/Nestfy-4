package com.example.backend.module.domain.models;

public interface IProduct {
    Long getId();
    void setId(Long id);

    String getName();
    void setName(String name);

    String getDescription();
    void setDescription(String description);

    String getImage();
    void setImage(String image);

    Double getUnitPrice();
    void setUnitPrice(Double unitPrice);

    Double getDiscountPercentage();
    void setDiscountPercentage(Double discountPercentage);

    Double getDiscountAmount();
    void setDiscountAmount(Double discountAmount);

    Double getFinalPrice();
    void setFinalPrice(Double finalPrice);

    Category getParent();
    void setParent(Category parent);
}
