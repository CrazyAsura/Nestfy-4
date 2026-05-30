package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.Admin;

public interface CreateAdminUseCasePortIn {
    Admin execute(Admin admin);
}
