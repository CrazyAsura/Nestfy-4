package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.Phone;
import com.example.backend.module.domain.ports.in.GetPhoneUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPhoneRepositoryPortOut;

public class GetPhoneUseCase implements GetPhoneUseCasePortIn {
    private final IPhoneRepositoryPortOut phoneRepositoryPortOut;

    public GetPhoneUseCase(IPhoneRepositoryPortOut phoneRepositoryPortOut) {
        this.phoneRepositoryPortOut = phoneRepositoryPortOut;
    }

    @Override
    public Phone execute(Long id) {
        return phoneRepositoryPortOut.findById(id).orElse(null);
    }
}

