package org.softuni.mostwanted.services.District;

import org.softuni.mostwanted.domain.dtos.binding.DistrictJSONImportDTO;
import org.softuni.mostwanted.domain.models.District;
import org.softuni.mostwanted.domain.models.Town;
import org.softuni.mostwanted.repositories.DistrictRepository;
import org.softuni.mostwanted.services.Town.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;
    private final TownService townService;

    @Autowired
    public DistrictServiceImpl(DistrictRepository districtRepository,
                               TownService townService) {
        this.districtRepository = districtRepository;
        this.townService = townService;
    }

    @Override
    public void create(DistrictJSONImportDTO dto) {
        Town town = this.townService.findByName(dto.getTownName());
        District byName = this.districtRepository.findByName(dto.getName());

        if (town == null || byName != null) {
            throw new IllegalArgumentException();
        } else {
            District district = new District();
            district.setName(dto.getName());
            district.setTown(town);
            town.getDistrict().add(district);
            this.districtRepository.saveAndFlush(district);
        }
    }
}