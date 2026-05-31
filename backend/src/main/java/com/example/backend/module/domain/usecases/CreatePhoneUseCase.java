package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.Phone;
import com.example.backend.module.domain.ports.in.CreatePhoneUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPhoneRepositoryPortOut;

@Component
public class CreatePhoneUseCase implements CreatePhoneUseCasePortIn {
    private final IPhoneRepositoryPortOut phoneRepositoryPortOut;

    public CreatePhoneUseCase(IPhoneRepositoryPortOut phoneRepositoryPortOut) {
        this.phoneRepositoryPortOut = phoneRepositoryPortOut;
    }

    @Override
    public Phone execute(Phone phone) {
        return phoneRepositoryPortOut.save(phone);
    }
}



