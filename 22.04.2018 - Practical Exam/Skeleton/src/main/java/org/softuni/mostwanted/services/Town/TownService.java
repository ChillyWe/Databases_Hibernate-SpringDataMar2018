package org.softuni.mostwanted.services.Town;

import org.softuni.mostwanted.domain.dtos.binding.TownJSONImportDTO;
import org.softuni.mostwanted.domain.models.Town;

import java.util.List;

public interface TownService {
    void create(TownJSONImportDTO dto);

    Town findByName(String name);

    List<Town> findAll();
}