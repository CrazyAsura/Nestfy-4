package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.Admin;
import com.example.backend.module.domain.ports.in.GetAdminUseCasePortIn;
import com.example.backend.module.domain.ports.out.IAdminRepositoryPortOut;

@Component
public class GetAdminUseCase implements GetAdminUseCasePortIn {
    private final IAdminRepositoryPortOut adminRepositoryPortOut;

    public GetAdminUseCase(IAdminRepositoryPortOut adminRepositoryPortOut) {
        this.adminRepositoryPortOut = adminRepositoryPortOut;
    }

    @Override
    public Admin execute(Long id) {
        java.util.Optional<Admin> result = adminRepositoryPortOut.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}

