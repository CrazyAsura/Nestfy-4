package com.example.backend.module.adapter.out.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.domain.models.Phone;
import com.example.backend.module.domain.models.TypePhone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

    public List<Phone> findByUserId(Long userId);

    public List<Phone> findByActive(Boolean active);

    public List<Phone> findByNumber(String number);

    public List<Phone> findByType(TypePhone type);
}
