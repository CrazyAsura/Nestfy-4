package com.example.backend.module.domain.models;

import java.time.LocalDateTime;
import java.util.Date;

public interface IUser {
    Long getId();
    void setId(Long id);

    String getName();
    void setName(String name);

    String getCpf();
    void setCpf(String cpf);

    String getCnpj();
    void setCnpj(String cnpj);

    Date getBirthDate();
    void setBirthDate(Date birthDate);

    String getEmail();
    void setEmail(String email);

    String getPassword();
    void setPassword(String password);

    TypeUser getType();
    void setType(TypeUser type);

    Phone getPhone();
    void setPhone(Phone phone);

    Address getAddress();
    void setAddress(Address address);

    Boolean getActive();
    void setActive(Boolean active);

    LocalDateTime getCreatedAt();
    void setCreatedAt(LocalDateTime createdAt);

    LocalDateTime getUpdatedAt();
    void setUpdatedAt(LocalDateTime updatedAt);
}
