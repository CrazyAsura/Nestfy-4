package com.example.backend.module.adapter.out.persistence.entities.interfaces;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Date;
import com.example.backend.module.adapter.out.persistence.entities.*;

@Getter
@Setter
public abstract class IUserEntity {

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

    public abstract TypeUserEntity getType();
    public abstract void setType(TypeUserEntity type);

    public abstract PhoneEntity getPhone();
    public abstract void setPhone(PhoneEntity phone);

    public abstract AddressEntity getAddress();
    public abstract void setAddress(AddressEntity address);

    public abstract Boolean getActive();
    public abstract void setActive(Boolean active);

    public abstract LocalDateTime getCreatedAt();
    public abstract void setCreatedAt(LocalDateTime createdAt);

    public abstract LocalDateTime getUpdatedAt();
    public abstract void setUpdatedAt(LocalDateTime updatedAt);
}
