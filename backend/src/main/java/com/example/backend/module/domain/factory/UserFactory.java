package com.example.backend.module.domain.factory;

import com.example.backend.module.domain.models.User;
import com.example.backend.module.domain.models.TypeUser;
import com.example.backend.module.domain.models.Phone;
import com.example.backend.module.domain.models.Address;
import java.time.LocalDateTime;

public class UserFactory {

    public static User createUser(Long id, String name, String email, String password, String cpf, String cnpj, TypeUser type, Phone phone, Address address, Boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new User(id, name, email, password, cpf, cnpj, type, phone, address, active, createdAt, updatedAt);
    }

    public static User createNewActiveUser(String name, String email, String password, String cpf, String cnpj, TypeUser type, Phone phone, Address address) {
        return new User(null, name, email, password, cpf, cnpj, type, phone, address, true, LocalDateTime.now(), LocalDateTime.now());
    }

    public static User createEmptyUser() {
        return new User();
    }
}
