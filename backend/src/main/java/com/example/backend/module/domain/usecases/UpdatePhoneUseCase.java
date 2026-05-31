package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.Phone;
import com.example.backend.module.domain.ports.in.UpdatePhoneUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPhoneRepositoryPortOut;

@Component
public class UpdatePhoneUseCase implements UpdatePhoneUseCasePortIn {
    private final IPhoneRepositoryPortOut phoneRepositoryPortOut;

    public UpdatePhoneUseCase(IPhoneRepositoryPortOut phoneRepositoryPortOut) {
        this.phoneRepositoryPortOut = phoneRepositoryPortOut;
    }

    @Override
    public Phone execute(Phone phone) {
        return phoneRepositoryPortOut.save(phone);
    }
}

