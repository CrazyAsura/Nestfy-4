package com.example.backend.module.adapter.out.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.util.Date;
import com.example.backend.module.adapter.out.persistence.entities.interfaces.*;

@Entity
@Table(name = "tb_sailor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SailorEntity extends ISailorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cpf;

    private String cnpj;

    private Date birthDate;

    private String email;

    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    private TypeUserEntity type;

    @ManyToOne(cascade = CascadeType.ALL)
    private PhoneEntity phone;

    @ManyToOne(cascade = CascadeType.ALL)
    private AddressEntity address;

    private Boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
