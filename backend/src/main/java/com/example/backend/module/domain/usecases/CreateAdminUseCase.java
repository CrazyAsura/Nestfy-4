package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.Admin;
import com.example.backend.module.domain.ports.in.CreateAdminUseCasePortIn;
import com.example.backend.module.domain.ports.out.IAdminRepositoryPortOut;

@Component
public class CreateAdminUseCase implements CreateAdminUseCasePortIn {

    private final IAdminRepositoryPortOut adminRepositoryPortOut;

    public CreateAdminUseCase(IAdminRepositoryPortOut adminRepositoryPortOut) {
        this.adminRepositoryPortOut = adminRepositoryPortOut;
    }

    @Override
    public Admin execute(Admin admin) {
        return adminRepositoryPortOut.save(admin);
    }

}



