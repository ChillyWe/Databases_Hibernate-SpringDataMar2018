package org.softuni.mostwanted.services.RaceEntry;

import org.softuni.mostwanted.domain.dtos.binding.raceEntry.RaceEntryXMLImportDTO;
import org.softuni.mostwanted.domain.models.Car;
import org.softuni.mostwanted.domain.models.RaceEntry;
import org.softuni.mostwanted.domain.models.Racer;
import org.softuni.mostwanted.repositories.RaceEntryRepository;
import org.softuni.mostwanted.services.Car.CarService;
import org.softuni.mostwanted.services.Racer.RacerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RaceEntryServiceImpl implements RaceEntryService {

    private final RaceEntryRepository raceEntryRepository;
    private final CarService carService;
    private final RacerService racerService;


    @Autowired
    public RaceEntryServiceImpl(RaceEntryRepository raceEntryRepository,
                                CarService carService,
                                RacerService racerService) {
        this.raceEntryRepository = raceEntryRepository;
        this.carService = carService;
        this.racerService = racerService;
    }

    @Override
    public Integer create(RaceEntryXMLImportDTO dto) {
        Car car = this.carService.getOneById(dto.getCarId());
        Racer racer = this.racerService.findByName(dto.getRacerName());

        if (car == null && racer == null) {
            throw new IllegalArgumentException();
        } else {
            RaceEntry entry = new RaceEntry();
            entry.setHasFinished(dto.isHasFinished());
            entry.setFinishTime(dto.getFinishTime());
            car.getEntries().add(entry);
            entry.setCar(car);
            racer.getEntries().add(entry);
            entry.setRacer(racer);
            this.raceEntryRepository.saveAndFlush(entry);
            return entry.getId();
        }
    }

    @Override
    public RaceEntry getById(Integer id) {
        return this.raceEntryRepository.findOne(id);
    }
}