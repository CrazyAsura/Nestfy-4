package com.example.backend.module.adapter.out.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.domain.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    public List<Address> findByUserId(Long userId);

    public List<Address> findByActive(Boolean active);

    public List<Address> findByZipCode(String zipCode);

    public List<Address> findByStreet(String street);

    public List<Address> findByNumber(String number);

    public List<Address> findByNeighborhood(String neighborhood);

    public List<Address> findByCity(String city);

    public List<Address> findByState(String state);

    public List<Address> findByCountry(String country);

    public List<Address> findByComplement(String complement);
    
}
