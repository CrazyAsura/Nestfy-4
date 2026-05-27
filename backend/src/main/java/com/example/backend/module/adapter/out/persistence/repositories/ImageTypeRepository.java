package com.example.backend.module.adapter.out.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.domain.models.ImageType;
import com.example.backend.module.domain.models.ImageTypeEnum;

@Repository
public interface ImageTypeRepository extends JpaRepository<ImageType, Long> {

    public List<ImageType> findByType(ImageTypeEnum type);
}
