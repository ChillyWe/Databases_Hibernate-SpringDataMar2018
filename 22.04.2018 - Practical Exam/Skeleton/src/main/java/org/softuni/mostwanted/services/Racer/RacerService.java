package org.softuni.mostwanted.services.Racer;

import org.softuni.mostwanted.domain.dtos.binding.RacerJSONImportDTO;
import org.softuni.mostwanted.domain.models.Racer;

public interface RacerService {
    void create(RacerJSONImportDTO dto);

    Racer findByName(String name);
}