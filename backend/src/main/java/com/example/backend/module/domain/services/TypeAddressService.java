package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.TypeAddress;
import com.example.backend.module.domain.ports.out.ITypeAddressRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateTypeAddressUseCase;
import com.example.backend.module.domain.usecases.DeleteTypeAddressUseCase;
import com.example.backend.module.domain.usecases.GetTypeAddressUseCase;
import com.example.backend.module.domain.usecases.UpdateTypeAddressUseCase;
import org.springframework.stereotype.Service;

@Service
public class TypeAddressService {
    private final CreateTypeAddressUseCase createTypeAddressUseCase;
    private final GetTypeAddressUseCase getTypeAddressUseCase;
    private final UpdateTypeAddressUseCase updateTypeAddressUseCase;
    private final DeleteTypeAddressUseCase deleteTypeAddressUseCase;

    public TypeAddressService(ITypeAddressRepositoryPortOut typeAddressRepositoryPortOut) {
        this.createTypeAddressUseCase = new CreateTypeAddressUseCase(typeAddressRepositoryPortOut);
        this.getTypeAddressUseCase = new GetTypeAddressUseCase(typeAddressRepositoryPortOut);
        this.updateTypeAddressUseCase = new UpdateTypeAddressUseCase(typeAddressRepositoryPortOut);
        this.deleteTypeAddressUseCase = new DeleteTypeAddressUseCase(typeAddressRepositoryPortOut);
    }

    public TypeAddress createTypeAddress(TypeAddress typeaddress) {
        return createTypeAddressUseCase.execute(typeaddress);
    }

    public TypeAddress getTypeAddress(Long id) {
        return getTypeAddressUseCase.execute(id);
    }

    public TypeAddress updateTypeAddress(TypeAddress typeaddress) {
        return updateTypeAddressUseCase.execute(typeaddress);
    }

    public void deleteTypeAddress(Long id) {
        deleteTypeAddressUseCase.execute(id);
    }
}
