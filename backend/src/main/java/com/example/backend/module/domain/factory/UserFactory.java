package com.example.backend.module.domain.factory;

import com.example.backend.module.domain.models.User;
import com.example.backend.module.domain.models.TypeUser;
import com.example.backend.module.domain.models.Phone;
import com.example.backend.module.domain.models.Address;
import com.example.backend.module.domain.factory.interfaces.IUserFactory;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class UserFactory implements IUserFactory {

    @Override
    public User createUser(Long id, String name, String email, String password, String cpf, String cnpj, TypeUser type, Phone phone, Address address, Boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new User(id, name, email, password, cpf, cnpj, type, phone, address, active, createdAt, updatedAt);
    }

    @Override
    public User createNewActiveUser(String name, String email, String password, String cpf, String cnpj, TypeUser type, Phone phone, Address address) {
        return new User(null, name, email, password, cpf, cnpj, type, phone, address, true, LocalDateTime.now(), LocalDateTime.now());
    }

    @Override
    public User createEmptyUser() {
        return new User();
    }
}
