package com.example.backend.module.domain.factory;

import com.example.backend.module.domain.models.SuperAdmin;
import com.example.backend.module.domain.models.User;
import com.example.backend.module.domain.models.TypeUser;
import com.example.backend.module.domain.models.Phone;
import com.example.backend.module.domain.models.Address;
import com.example.backend.module.domain.factory.interfaces.ISuperAdminFactory;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class SuperAdminFactory implements ISuperAdminFactory {

    @Override
    public SuperAdmin createSuperAdmin(Long id, String name, String email, String password, String cpf, String cnpj, TypeUser type, Phone phone, Address address, Boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        User user = new User(id, name, email, password, cpf, cnpj, type, phone, address, active, createdAt, updatedAt);
        return new SuperAdmin(id, user, type, active);
    }
}
