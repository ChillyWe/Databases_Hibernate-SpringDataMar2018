package org.softuni.mostwanted.services.Race;

import org.softuni.mostwanted.domain.dtos.binding.race.RaceXMLImportDTO;
import org.softuni.mostwanted.domain.models.District;
import org.softuni.mostwanted.domain.models.Race;
import org.softuni.mostwanted.domain.models.RaceEntry;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.RaceRepository;
import org.softuni.mostwanted.services.District.DistrictService;
import org.softuni.mostwanted.services.RaceEntry.RaceEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class RaceServiceImpl implements RaceService {

    private final RaceRepository raceRepository;
    private final RaceEntryService raceEntryService;
    private final ModelParser mapper;
    private final DistrictService districtService;

    @Autowired
    public RaceServiceImpl(RaceRepository raceRepository,
                           RaceEntryService raceEntryService,
                           ModelParser modelMapper,
                           DistrictService districtService) {
        this.raceRepository = raceRepository;
        this.raceEntryService = raceEntryService;
        this.mapper = modelMapper;
        this.districtService = districtService;
    }

    @Override
    public Integer create(RaceXMLImportDTO dto) {

        // TODO return null <--- why ?
        Set<RaceEntry> entries = dto.getRaceEntries()
                .stream().map(m -> this.raceEntryService.getById(m.getId())).collect(Collectors.toSet());

        Race race = new Race();
        race.setLaps(dto.getLaps());
        District dist = this.districtService.getOneByName(dto.getDistrictName());
        dist.getRaces().add(race);
        race.setDistrict(dist);
        entries.forEach(raceEntry -> raceEntry.setRace(race));
        race.setEntries(entries);
        this.raceRepository.saveAndFlush(race);
        String debug = "";
        return race.getId();
    }
}