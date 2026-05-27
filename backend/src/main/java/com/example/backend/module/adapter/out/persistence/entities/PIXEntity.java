package com.example.backend.module.adapter.out.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.backend.module.domain.models.TypeKeyPixEnum;
import com.example.backend.module.adapter.out.persistence.entities.interfaces.*;

@Entity
@Table(name = "tb_p_i_x")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PIXEntity extends IPIXEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String chavePix;

    private TypeKeyPixEnum typeKeyPix;

    private String description;

    private Boolean active;
}
