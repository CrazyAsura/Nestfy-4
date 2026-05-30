package com.example.backend.module.domain.factory.interfaces;

import com.example.backend.module.domain.models.SuperAdmin;
import com.example.backend.module.domain.models.TypeUser;
import com.example.backend.module.domain.models.Phone;
import com.example.backend.module.domain.models.Address;
import java.time.LocalDateTime;

public interface ISuperAdminFactory {
    SuperAdmin createSuperAdmin(Long id, String name, String email, String password, String cpf, String cnpj, TypeUser type, Phone phone, Address address, Boolean active, LocalDateTime createdAt, LocalDateTime updatedAt);
}
