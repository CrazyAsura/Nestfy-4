package com.example.backend.module.adapter.out.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.domain.models.TypePhoneEnum;
import com.example.backend.module.domain.models.TypePhone;
import com.example.backend.module.domain.models.User;

@Repository
public interface TypePhoneRepository extends JpaRepository<TypePhone, Long> {

    public List<TypePhone> findByType(TypePhoneEnum type);

    public List<TypePhone> findByUser(User user);
}
