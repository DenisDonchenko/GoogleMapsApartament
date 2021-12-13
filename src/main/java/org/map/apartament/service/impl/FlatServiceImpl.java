package org.map.apartament.service.impl;

import org.map.apartament.model.Flat;
import org.map.apartament.repository.FlatRepository;
import org.map.apartament.service.FlatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlatServiceImpl implements FlatService {

    public final FlatRepository flatRepository;

    public FlatServiceImpl(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }

    @Override
    public Flat save(Flat flat) {
        return flatRepository.save(flat);
    }

    @Override
    public List<Flat> findAll() {
        return flatRepository.findAll();
    }
}
