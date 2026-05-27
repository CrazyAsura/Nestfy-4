package com.example.backend.module.domain.ports.out;

import java.util.List;
import com.example.backend.module.domain.models.TypeUser;
import com.example.backend.module.domain.models.TypeUserEnum;
import com.example.backend.module.domain.models.User;

public interface TypeUserRepositoryPortOut extends IRepositoryPortOut<TypeUser, Long> {
    List<TypeUser> findByType(TypeUserEnum type);
    List<TypeUser> findByUser(User user);
}
