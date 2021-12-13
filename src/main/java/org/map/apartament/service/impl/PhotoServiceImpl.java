package org.map.apartament.service.impl;

import org.map.apartament.model.Photo;
import org.map.apartament.repository.PhotoRepository;
import org.map.apartament.service.PhotoService;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;

    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public void save(Photo photo) {
        photoRepository.save(photo);
    }

}
