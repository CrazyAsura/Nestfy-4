package com.example.backend.module.adapter.out.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.backend.module.domain.models.TypeAddressEnum;
import com.example.backend.module.adapter.out.persistence.entities.interfaces.*;

@Entity
@Table(name = "tb_type_address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeAddressEntity extends ITypeAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TypeAddressEnum type;

    @ManyToOne(cascade = CascadeType.ALL)
    private AddressEntity address;
}
