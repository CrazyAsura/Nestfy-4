package com.example.backend.module.adapter.out.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.domain.models.TypeUser;
import com.example.backend.module.domain.models.TypeUserEnum;
import com.example.backend.module.domain.models.User;

@Repository
public interface TypeUserRepository extends JpaRepository<TypeUser, Long> {

    public List<TypeUser> findByType(TypeUserEnum type);

    public List<TypeUser> findByUser(User user);
}
