package org.map.apartament.service.impl;

import org.map.apartament.model.Coordinates;
import org.map.apartament.repository.CoordinatesRepository;
import org.map.apartament.service.CoordinatesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinatesServiceImpl implements CoordinatesService {

    public final CoordinatesRepository coordinatesRepository;

    public CoordinatesServiceImpl(CoordinatesRepository coordinatesRepository) {
        this.coordinatesRepository = coordinatesRepository;
    }

    @Override
    public void save(Coordinates coordinates) {
        coordinatesRepository.save(coordinates);
    }

    @Override
    public List<Coordinates> findAll() {
        return coordinatesRepository.findAll();
    }
}
