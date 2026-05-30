package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.PIX;
import com.example.backend.module.domain.ports.in.UpdatePIXUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPIXRepositoryPortOut;

public class UpdatePIXUseCase implements UpdatePIXUseCasePortIn {
    private final IPIXRepositoryPortOut pixRepositoryPortOut;

    public UpdatePIXUseCase(IPIXRepositoryPortOut pixRepositoryPortOut) {
        this.pixRepositoryPortOut = pixRepositoryPortOut;
    }

    @Override
    public PIX execute(PIX pix) {
        return pixRepositoryPortOut.save(pix);
    }
}

