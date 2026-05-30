package com.example.backend.module.domain.factory;

import com.example.backend.module.domain.models.Image;
import com.example.backend.module.domain.models.ImageType;
import com.example.backend.module.domain.factory.interfaces.IImageFactory;
import org.springframework.stereotype.Component;

@Component
public class ImageFactory implements IImageFactory {

    @Override
    public Image createImage(Long id, String name, String type, String url, ImageType imageType) {
        return new Image(id, name, type, url, imageType);
    }
}
