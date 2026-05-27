package com.example.backend.module.domain.models;

import com.example.backend.module.domain.models.interfaces.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Image extends IImage {
    
    private Long id;
    private String name;
    private String type;
    private String url;
    private ImageType imageType;

    public Image() {
    }

    public Image(Long id, String name, String type, String url, ImageType imageType) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.url = url;
        this.imageType = imageType;
    }
}