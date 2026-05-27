package com.example.backend.module.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PIX implements IPIX {

    private Long id;
    private String chavePix;
    private TypeKeyPixEnum typeKeyPix;
    private String description;
    private Boolean active;
    
    public PIX(Long id, String chavePix, TypeKeyPixEnum typeKeyPix, String description, Boolean active) {
        this.id = id;
        this.chavePix = chavePix;
        this.typeKeyPix = typeKeyPix;
        this.description = description;
        this.active = active;
    }

    public PIX() {
    }
}