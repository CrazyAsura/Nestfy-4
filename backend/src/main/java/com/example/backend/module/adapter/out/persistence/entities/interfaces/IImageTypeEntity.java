package com.example.backend.module.adapter.out.persistence.entities.interfaces;

import lombok.Getter;
import lombok.Setter;
import com.example.backend.module.domain.models.ImageTypeEnum;
import java.util.List;
import com.example.backend.module.adapter.out.persistence.entities.*;

@Getter
@Setter
public abstract class IImageTypeEntity {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract ImageTypeEnum getType();
    public abstract void setType(ImageTypeEnum type);

    public abstract List<ImageEntity> getImage();
    public abstract void setImage(List<ImageEntity> image);
}
