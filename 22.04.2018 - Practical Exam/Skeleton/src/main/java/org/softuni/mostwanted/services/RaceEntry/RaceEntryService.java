package org.softuni.mostwanted.services.RaceEntry;

import org.softuni.mostwanted.domain.dtos.binding.RaceEntryXMLImportDTO;

public interface RaceEntryService {
    void create(RaceEntryXMLImportDTO dto);
}