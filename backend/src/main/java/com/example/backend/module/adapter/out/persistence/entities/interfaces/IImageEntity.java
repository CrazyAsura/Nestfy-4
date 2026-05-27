package com.example.backend.module.adapter.out.persistence.entities.interfaces;

import lombok.Getter;
import lombok.Setter;
import com.example.backend.module.adapter.out.persistence.entities.*;

@Getter
@Setter
public abstract class IImageEntity {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract String getName();
    public abstract void setName(String name);

    public abstract String getType();
    public abstract void setType(String type);

    public abstract String getUrl();
    public abstract void setUrl(String url);

    public abstract ImageTypeEntity getImageType();
    public abstract void setImageType(ImageTypeEntity imageType);
}
