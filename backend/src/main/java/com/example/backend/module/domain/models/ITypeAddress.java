package com.example.backend.module.domain.models;

public interface ITypeAddress {
    Long getId();
    void setId(Long id);

    TypeAddressEnum getType();
    void setType(TypeAddressEnum type);

    Address getAddress();
    void setAddress(Address address);
}
