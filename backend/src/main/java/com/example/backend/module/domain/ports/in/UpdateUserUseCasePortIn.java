package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.User;

public interface UpdateUserUseCasePortIn {
    User execute(User user);
}
