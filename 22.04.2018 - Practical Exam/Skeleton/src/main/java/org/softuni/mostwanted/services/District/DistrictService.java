package org.softuni.mostwanted.services.District;


import org.softuni.mostwanted.domain.dtos.binding.DistrictJSONImportDTO;

public interface DistrictService{
    void create(DistrictJSONImportDTO dto);
}