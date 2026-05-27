package com.example.backend.module.adapter.out.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.domain.models.Image;
import com.example.backend.module.domain.models.ImageType;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    public List<Image> findByName(String name);

    public List<Image> findByImageType(ImageType imageType);
}
