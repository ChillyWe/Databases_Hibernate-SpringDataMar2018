package org.softuni.mostwanted.services.Race;

import org.softuni.mostwanted.domain.dtos.binding.race.RaceXMLImportDTO;

public interface RaceService {
    Integer create(RaceXMLImportDTO dto);
}