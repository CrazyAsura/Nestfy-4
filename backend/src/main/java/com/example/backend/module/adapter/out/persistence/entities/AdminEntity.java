package com.example.backend.module.adapter.out.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.backend.module.adapter.out.persistence.entities.interfaces.*;

@Entity
@Table(name = "tb_admin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminEntity extends IAdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity user;

    @ManyToOne(cascade = CascadeType.ALL)
    private TypeUserEntity type;

    private Boolean active;
}
