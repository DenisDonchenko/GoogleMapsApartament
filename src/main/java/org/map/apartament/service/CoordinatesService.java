package org.map.apartament.service;

import org.map.apartament.model.Coordinates;

import java.util.List;

public interface CoordinatesService {

    void save(Coordinates coordinates);

    List<Coordinates> findAll();
}
