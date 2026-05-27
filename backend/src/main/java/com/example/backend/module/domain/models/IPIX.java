package com.example.backend.module.domain.models;

public interface IPIX {
    Long getId();
    void setId(Long id);

    String getChavePix();
    void setChavePix(String chavePix);

    TypeKeyPixEnum getTypeKeyPix();
    void setTypeKeyPix(TypeKeyPixEnum typeKeyPix);

    String getDescription();
    void setDescription(String description);

    Boolean getActive();
    void setActive(Boolean active);
}
