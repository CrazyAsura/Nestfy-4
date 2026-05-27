package com.example.backend.module.domain.models;

public interface IClient {
    Long getId();
    void setId(Long id);

    User getUser();
    void setUser(User user);

    TypeUser getType();
    void setType(TypeUser type);

    Boolean getActive();
    void setActive(Boolean active);
}
