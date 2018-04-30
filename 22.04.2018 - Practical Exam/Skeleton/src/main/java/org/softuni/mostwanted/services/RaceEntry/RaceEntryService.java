package org.softuni.mostwanted.services.RaceEntry;

import org.softuni.mostwanted.domain.dtos.binding.raceEntry.RaceEntryXMLImportDTO;
import org.softuni.mostwanted.domain.models.RaceEntry;

public interface RaceEntryService {
    Integer create(RaceEntryXMLImportDTO dto);

    RaceEntry getById(Integer id);
}