package com.example.backend.module.domain.models;

public interface ITypeUser {
    Long getId();
    void setId(Long id);

    TypeUserEnum getType();
    void setType(TypeUserEnum type);

    User getUser();
    void setUser(User user);
}
