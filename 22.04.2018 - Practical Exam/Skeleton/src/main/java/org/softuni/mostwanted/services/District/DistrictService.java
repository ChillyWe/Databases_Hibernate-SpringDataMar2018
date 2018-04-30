package org.softuni.mostwanted.services.District;


import org.softuni.mostwanted.domain.dtos.binding.DistrictJSONImportDTO;
import org.softuni.mostwanted.domain.models.District;

public interface DistrictService{
    void create(DistrictJSONImportDTO dto);

    District getOneByName(String districtName);

}