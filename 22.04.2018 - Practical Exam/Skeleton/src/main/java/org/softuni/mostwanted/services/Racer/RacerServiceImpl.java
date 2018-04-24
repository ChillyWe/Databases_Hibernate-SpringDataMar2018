package org.softuni.mostwanted.services.Racer;

import org.softuni.mostwanted.domain.dtos.binding.RacerJSONImportDTO;
import org.softuni.mostwanted.domain.models.Racer;
import org.softuni.mostwanted.domain.models.Town;
import org.softuni.mostwanted.repositories.RacerRepository;
import org.softuni.mostwanted.services.Town.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RacerServiceImpl implements RacerService {

    private final RacerRepository racerRepository;
    private final TownService townService;

    @Autowired
    public RacerServiceImpl(RacerRepository racerRepository,
                            TownService townService) {
        this.racerRepository = racerRepository;
        this.townService = townService;
    }

    @Override
    public void create(RacerJSONImportDTO dto) {
        Town townByName = this.townService.findByName(dto.getHomeTown());
        Racer racerByName = this.racerRepository.findByName(dto.getName());

        if (townByName == null || racerByName != null) {
            throw new IllegalArgumentException();
        } else {
            Racer racer = new Racer();
            racer.setName(dto.getName());
            racer.setAge(dto.getAge());
            racer.setBounty(dto.getBounty());
            racer.setHomeTown(townByName);
            townByName.getRacers().add(racer);

            this.racerRepository.saveAndFlush(racer);
        }
    }

    @Override
    public Racer findByName(String name) {
        return this.racerRepository.findByName(name);
    }
}