package com.example.backend.module.domain.models.interfaces;

import com.example.backend.module.domain.models.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class IAdmin {

    private Long id;
    private User user;
    private TypeUser type;
    private Boolean active;

}
