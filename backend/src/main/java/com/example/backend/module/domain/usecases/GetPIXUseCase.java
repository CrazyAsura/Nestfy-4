package com.example.backend.module.domain.usecases;

import com.example.backend.module.domain.models.PIX;
import com.example.backend.module.domain.ports.in.GetPIXUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPIXRepositoryPortOut;
import org.springframework.stereotype.Component;

@Component
public class GetPIXUseCase implements GetPIXUseCasePortIn {
    private final IPIXRepositoryPortOut pixRepositoryPortOut;

    public GetPIXUseCase(IPIXRepositoryPortOut pixRepositoryPortOut) {
        this.pixRepositoryPortOut = pixRepositoryPortOut;
    }

    @Override
    public PIX execute(Long id) {
        return pixRepositoryPortOut.findById(id).orElse(null);
    }
}
