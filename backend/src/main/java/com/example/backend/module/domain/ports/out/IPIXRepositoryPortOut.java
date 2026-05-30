package com.example.backend.module.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.example.backend.module.domain.models.PIX;

public interface IPIXRepositoryPortOut extends IRepositoryPortOut<PIX, Long> {

    public Optional<PIX> findByKey(String key);

    public List<PIX> findByActive(Boolean active);

    public List<PIX> findByClientId(Long clientId);

}

