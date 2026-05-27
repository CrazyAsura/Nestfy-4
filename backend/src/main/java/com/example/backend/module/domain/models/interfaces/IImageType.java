package com.example.backend.module.domain.models.interfaces;

import java.util.List;

import com.example.backend.module.domain.models.*;

public abstract class IImageType {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract ImageTypeEnum getType();
    public abstract void setType(ImageTypeEnum type);

    public abstract List<Image> getImage();
    public abstract void setImage(List<Image> image);
}