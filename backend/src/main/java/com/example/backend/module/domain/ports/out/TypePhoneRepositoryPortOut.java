package com.example.backend.module.domain.ports.out;

import java.util.List;

import com.example.backend.module.domain.models.TypePhone;
import com.example.backend.module.domain.models.TypePhoneEnum;
import com.example.backend.module.domain.models.User;

public interface TypePhoneRepositoryPortOut extends IRepositoryPortOut<TypePhone, Long> {
    List<TypePhone> findByType(TypePhoneEnum type);
    List<TypePhone> findByUser(User user);
    
}
