package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.SuperAdmin;

public interface GetSuperAdminUseCasePortIn {
    SuperAdmin execute(Long id);
}
