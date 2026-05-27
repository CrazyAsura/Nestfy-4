package com.example.backend.module.adapter.out.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.backend.module.adapter.out.persistence.entities.interfaces.*;

@Entity
@Table(name = "tb_phone")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneEntity extends IPhoneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ddi;

    private String ddd;

    private String number;

    @ManyToOne(cascade = CascadeType.ALL)
    private TypePhoneEntity type;

    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity user;
}
