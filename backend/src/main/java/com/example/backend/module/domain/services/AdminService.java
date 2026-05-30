package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.Admin;
import com.example.backend.module.domain.ports.out.IAdminRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateAdminUseCase;
import com.example.backend.module.domain.usecases.DeleteAdminUseCase;
import com.example.backend.module.domain.usecases.GetAdminUseCase;
import com.example.backend.module.domain.usecases.UpdateAdminUseCase;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final CreateAdminUseCase createAdminUseCase;
    private final GetAdminUseCase getAdminUseCase;
    private final UpdateAdminUseCase updateAdminUseCase;
    private final DeleteAdminUseCase deleteAdminUseCase;

    public AdminService(IAdminRepositoryPortOut adminRepositoryPortOut) {
        this.createAdminUseCase = new CreateAdminUseCase(adminRepositoryPortOut);
        this.getAdminUseCase = new GetAdminUseCase(adminRepositoryPortOut);
        this.updateAdminUseCase = new UpdateAdminUseCase(adminRepositoryPortOut);
        this.deleteAdminUseCase = new DeleteAdminUseCase(adminRepositoryPortOut);
    }

    public Admin createAdmin(Admin admin) {
        return createAdminUseCase.execute(admin);
    }

    public Admin getAdmin(Long id) {
        return getAdminUseCase.execute(id);
    }

    public Admin updateAdmin(Admin admin) {
        return updateAdminUseCase.execute(admin);
    }

    public void deleteAdmin(Long id) {
        deleteAdminUseCase.execute(id);
    }
}
