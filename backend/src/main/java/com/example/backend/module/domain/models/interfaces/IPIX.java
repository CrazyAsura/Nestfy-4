package com.example.backend.module.domain.models.interfaces;

import com.example.backend.module.domain.models.TypeKeyPixEnum;

public abstract class IPIX {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract String getChavePix();
    public abstract void setChavePix(String chavePix);

    public abstract TypeKeyPixEnum getTypeKeyPix();
    public abstract void setTypeKeyPix(TypeKeyPixEnum typeKeyPix);

    public abstract String getDescription();
    public abstract void setDescription(String description);

    public abstract Boolean getActive();
    public abstract void setActive(Boolean active);
}