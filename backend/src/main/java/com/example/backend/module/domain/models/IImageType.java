package com.example.backend.module.domain.models;

import java.util.List;

public interface IImageType {
    Long getId();
    void setId(Long id);

    ImageTypeEnum getType();
    void setType(ImageTypeEnum type);

    List<Image> getImage();
    void setImage(List<Image> image);
}
