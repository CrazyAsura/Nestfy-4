package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.SuperAdmin;

public interface UpdateSuperAdminUseCasePortIn {
    SuperAdmin execute(SuperAdmin superAdmin);
}
