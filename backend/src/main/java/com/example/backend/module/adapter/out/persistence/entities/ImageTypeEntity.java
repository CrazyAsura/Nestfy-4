package com.example.backend.module.adapter.out.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.backend.module.domain.models.ImageTypeEnum;
import java.util.List;
import com.example.backend.module.adapter.out.persistence.entities.interfaces.*;

@Entity
@Table(name = "tb_image_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageTypeEntity extends IImageTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ImageTypeEnum type;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImageEntity> image;
}
