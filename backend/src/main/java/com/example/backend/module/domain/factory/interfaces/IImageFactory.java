package com.example.backend.module.domain.factory.interfaces;

import com.example.backend.module.domain.models.Image;
import com.example.backend.module.domain.models.ImageType;

public interface IImageFactory {
    Image createImage(Long id, String name, String type, String url, ImageType imageType);
}
