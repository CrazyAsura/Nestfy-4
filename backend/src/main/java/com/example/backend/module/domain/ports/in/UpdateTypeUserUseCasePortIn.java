package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.TypeUser;

public interface UpdateTypeUserUseCasePortIn {
    TypeUser execute(TypeUser typeUser);
}
