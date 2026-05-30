package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.TypeUser;
import com.example.backend.module.domain.ports.out.ITypeUserRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateTypeUserUseCase;
import com.example.backend.module.domain.usecases.DeleteTypeUserUseCase;
import com.example.backend.module.domain.usecases.GetTypeUserUseCase;
import com.example.backend.module.domain.usecases.UpdateTypeUserUseCase;
import org.springframework.stereotype.Service;

@Service
public class TypeUserService {
    private final CreateTypeUserUseCase createTypeUserUseCase;
    private final GetTypeUserUseCase getTypeUserUseCase;
    private final UpdateTypeUserUseCase updateTypeUserUseCase;
    private final DeleteTypeUserUseCase deleteTypeUserUseCase;

    public TypeUserService(ITypeUserRepositoryPortOut typeUserRepositoryPortOut) {
        this.createTypeUserUseCase = new CreateTypeUserUseCase(typeUserRepositoryPortOut);
        this.getTypeUserUseCase = new GetTypeUserUseCase(typeUserRepositoryPortOut);
        this.updateTypeUserUseCase = new UpdateTypeUserUseCase(typeUserRepositoryPortOut);
        this.deleteTypeUserUseCase = new DeleteTypeUserUseCase(typeUserRepositoryPortOut);
    }

    public TypeUser createTypeUser(TypeUser typeuser) {
        return createTypeUserUseCase.execute(typeuser);
    }

    public TypeUser getTypeUser(Long id) {
        return getTypeUserUseCase.execute(id);
    }

    public TypeUser updateTypeUser(TypeUser typeuser) {
        return updateTypeUserUseCase.execute(typeuser);
    }

    public void deleteTypeUser(Long id) {
        deleteTypeUserUseCase.execute(id);
    }
}
