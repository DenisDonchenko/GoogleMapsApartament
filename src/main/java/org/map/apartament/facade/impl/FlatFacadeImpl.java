package org.map.apartament.facade.impl;
/*
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;*/
import org.apache.commons.net.util.Base64;
import org.map.apartament.facade.FlatFacade;
import org.map.apartament.model.Coordinates;
import org.map.apartament.model.Flat;
import org.map.apartament.model.Photo;
import org.map.apartament.model.dto.flat.FlatDto;
import org.map.apartament.model.dto.flat.FlatDtoOutput;
import org.map.apartament.service.CoordinatesService;
import org.map.apartament.service.FlatService;
import org.map.apartament.service.PhotoService;
import org.map.apartament.service.impl.CoordinatesServiceImpl;
import org.map.apartament.service.impl.FlatServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FlatFacadeImpl implements FlatFacade {

    private final FlatService flatService;
    private final CoordinatesService coordinatesService;
    private final PhotoService photoService;

    public FlatFacadeImpl(FlatServiceImpl flatService, CoordinatesServiceImpl coordinatesService, PhotoService photoService) {
        this.flatService = flatService;
        this.coordinatesService = coordinatesService;
        this.photoService = photoService;
    }

    @Override
    public void saveFlat(FlatDto dto) throws IOException {
        Coordinates coordinates = createCoordinates(dto);
        Flat flat = createFlat(dto);
        flat.setCoordinates(coordinates);

        coordinatesService.save(coordinates);
        flat = flatService.save(flat);

        for (MultipartFile multipartFile : dto.getPhotos()) {
            Photo photoEntity = new Photo();
            byte[] photo = fileToArrayByte(multipartFile);
            photoEntity.setPhoto(photo);
            photoEntity.setFlat(flat);

            photoService.save(photoEntity);
        }
    }
    public void savePhoto( MultipartFile photoFile, Flat flat) throws IOException {
        Photo photoEntity = new Photo();
        byte[] photo = fileToArrayByte(photoFile);
        photoEntity.setPhoto(photo);
        photoEntity.setFlat(flat);
        photoService.save(photoEntity);
    }

    @Override
    public List<FlatDtoOutput> findAllFlat() {
        List<Flat> flats = flatService.findAll();

        return flats.stream()
                .map(flat -> new FlatDtoOutput(flat.getRooms(), flat.getSquare(),
                        flat.getDescription(), flat.getAddress(), flat.getCoordinates().getLatitude(),
                        flat.getCoordinates().getLongitude(), createEncodePhoto(flat.getPhoto())))
                .collect(Collectors.toList());
    }

    private Set<String> createEncodePhoto(Set<Photo> photoSet) {
        return photoSet.stream()
                .map(photo -> Base64.encodeBase64String(photo.getPhoto()))
                .collect(Collectors.toSet());
    }


    private Coordinates createCoordinates(FlatDto dto) {
        Coordinates coordinates = new Coordinates();
        coordinates.setLongitude(dto.getLongitude());
        coordinates.setLatitude(dto.getLatitude());

        return coordinates;
    }

    private Flat createFlat(FlatDto dto) {
        Flat flat = new Flat();

        flat.setAddress(dto.getAddress());
        flat.setDescription(dto.getDescription());
        flat.setRooms(dto.getRooms());
        flat.setSquare(dto.getSquare());
        return flat;
    }

    public byte[] fileToArrayByte(MultipartFile file) throws IOException {
        return file.getBytes();
    }
}
