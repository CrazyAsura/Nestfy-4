package com.example.backend.module.adapter.out.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.domain.models.Client;
import com.example.backend.module.domain.models.User;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    public List<Client> findByUser(User user);

    public List<Client> findByActive(Boolean active);
}
