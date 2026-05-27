package com.example.backend.module.domain.models.interfaces;

import java.time.LocalDateTime;
import java.util.Date;

import com.example.backend.module.domain.models.*;

public abstract class IUser {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract String getName();
    public abstract void setName(String name);

    public abstract String getCpf();
    public abstract void setCpf(String cpf);

    public abstract String getCnpj();
    public abstract void setCnpj(String cnpj);

    public abstract Date getBirthDate();
    public abstract void setBirthDate(Date birthDate);

    public abstract String getEmail();
    public abstract void setEmail(String email);

    public abstract String getPassword();
    public abstract void setPassword(String password);

    public abstract TypeUser getType();
    public abstract void setType(TypeUser type);

    public abstract Phone getPhone();
    public abstract void setPhone(Phone phone);

    public abstract Address getAddress();
    public abstract void setAddress(Address address);

    public abstract Boolean getActive();
    public abstract void setActive(Boolean active);

    public abstract LocalDateTime getCreatedAt();
    public abstract void setCreatedAt(LocalDateTime createdAt);

    public abstract LocalDateTime getUpdatedAt();
    public abstract void setUpdatedAt(LocalDateTime updatedAt);
}