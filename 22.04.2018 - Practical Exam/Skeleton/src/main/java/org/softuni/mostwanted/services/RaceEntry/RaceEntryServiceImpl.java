package org.softuni.mostwanted.services.RaceEntry;

import org.softuni.mostwanted.domain.dtos.binding.RaceEntryXMLImportDTO;
import org.softuni.mostwanted.repositories.RaceEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RaceEntryServiceImpl implements RaceEntryService {

    private final RaceEntryRepository raceEntryRepository;

    @Autowired
    public RaceEntryServiceImpl(RaceEntryRepository raceEntryRepository) {
        this.raceEntryRepository = raceEntryRepository;
    }

    @Override
    public void create(RaceEntryXMLImportDTO dto) {

        String debug = "";
    }
}