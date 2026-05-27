package com.example.backend.module.domain.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageType implements IImageType {

    private Long id;
    private ImageTypeEnum type;
    private List<Image> image;

    public ImageType(Long id, ImageTypeEnum type, List<Image> image) {
        this.id = id;
        this.type = type;
        this.image = image;
    }

    public ImageType() {
    }
}
