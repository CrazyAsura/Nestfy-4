package com.example.backend.module.domain.models;

public interface ITypePhone {
    Long getId();
    void setId(Long id);

    TypePhoneEnum getType();
    void setType(TypePhoneEnum type);

    User getUser();
    void setUser(User user);
}
