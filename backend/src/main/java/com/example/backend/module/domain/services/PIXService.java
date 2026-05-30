package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.PIX;
import com.example.backend.module.domain.ports.out.IPIXRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreatePIXUseCase;
import com.example.backend.module.domain.usecases.DeletePIXUseCase;
import com.example.backend.module.domain.usecases.GetPIXUseCase;
import com.example.backend.module.domain.usecases.UpdatePIXUseCase;
import org.springframework.stereotype.Service;

@Service
public class PIXService {
    private final CreatePIXUseCase createPIXUseCase;
    private final GetPIXUseCase getPIXUseCase;
    private final UpdatePIXUseCase updatePIXUseCase;
    private final DeletePIXUseCase deletePIXUseCase;

    public PIXService(IPIXRepositoryPortOut pIXRepositoryPortOut) {
        this.createPIXUseCase = new CreatePIXUseCase(pIXRepositoryPortOut);
        this.getPIXUseCase = new GetPIXUseCase(pIXRepositoryPortOut);
        this.updatePIXUseCase = new UpdatePIXUseCase(pIXRepositoryPortOut);
        this.deletePIXUseCase = new DeletePIXUseCase(pIXRepositoryPortOut);
    }

    public PIX createPIX(PIX pix) {
        return createPIXUseCase.execute(pix);
    }

    public PIX getPIX(Long id) {
        return getPIXUseCase.execute(id);
    }

    public PIX updatePIX(PIX pix) {
        return updatePIXUseCase.execute(pix);
    }

    public void deletePIX(Long id) {
        deletePIXUseCase.execute(id);
    }
}
