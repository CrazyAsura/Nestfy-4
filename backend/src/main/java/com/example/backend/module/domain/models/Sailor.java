package com.example.backend.module.domain.models;

import com.example.backend.module.domain.models.interfaces.*;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sailor extends ISailor {

    private Long id;
    private String name;
    private String cpf;
    private String cnpj;
    private Date birthDate;
    private String email;
    private String password;
    private TypeUser type;
    private Phone phone;
    private Address address;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Sailor() {
    }
    
    public Sailor(Long id, String name, String email, String password, String cpf, String cnpj, TypeUser type, Phone phone, Address address, Boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.type = type;
        this.phone = phone;
        this.address = address;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
