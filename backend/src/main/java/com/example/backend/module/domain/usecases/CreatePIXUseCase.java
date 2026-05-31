package com.example.backend.module.domain.usecases;

import com.example.backend.module.domain.models.PIX;
import com.example.backend.module.domain.ports.in.CreatePIXUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPIXRepositoryPortOut;
import org.springframework.stereotype.Component;

@Component
public class CreatePIXUseCase implements CreatePIXUseCasePortIn {
    private final IPIXRepositoryPortOut pIXRepositoryPortOut;

    public CreatePIXUseCase(IPIXRepositoryPortOut pIXRepositoryPortOut) {
        this.pIXRepositoryPortOut = pIXRepositoryPortOut;
    }

    @Override
    public PIX execute(PIX pix) {
        return pIXRepositoryPortOut.save(pix);
    }
}
