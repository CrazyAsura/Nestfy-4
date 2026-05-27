package com.example.backend.module.domain.models;

public interface IPhone {
    Long getId();
    void setId(Long id);

    String getDdi();
    void setDdi(String ddi);

    String getDdd();
    void setDdd(String ddd);

    String getNumber();
    void setNumber(String number);

    TypePhone getType();
    void setType(TypePhone type);

    User getUser();
    void setUser(User user);
}
