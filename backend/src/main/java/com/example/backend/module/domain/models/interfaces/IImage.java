package com.example.backend.module.domain.models.interfaces;

import com.example.backend.module.domain.models.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class IImage {

    private Long id;
    private String name;
    private String type;
    private String url;
    private ImageType imageType;
}