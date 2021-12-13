package org.map.apartament.facade;

import org.map.apartament.model.dto.flat.FlatDto;
import org.map.apartament.model.dto.flat.FlatDtoOutput;

import java.io.IOException;
import java.util.List;

public interface FlatFacade {

    void saveFlat(FlatDto dto) throws IOException;

    List<FlatDtoOutput> findAllFlat();
}
