package com.example.backend.module.adapter.out.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.backend.module.domain.models.TypeUserEnum;
import com.example.backend.module.adapter.out.persistence.entities.interfaces.*;

@Entity
@Table(name = "tb_type_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeUserEntity extends ITypeUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TypeUserEnum type;

    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity user;
}
