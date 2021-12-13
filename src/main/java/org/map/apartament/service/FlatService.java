package org.map.apartament.service;

import org.map.apartament.model.Flat;

import java.util.List;

public interface FlatService {

    Flat save(Flat flat);

    List<Flat> findAll();
}
