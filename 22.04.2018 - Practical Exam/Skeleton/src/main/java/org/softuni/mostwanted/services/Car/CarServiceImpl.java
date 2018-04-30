package org.softuni.mostwanted.services.Car;

import org.softuni.mostwanted.domain.dtos.binding.CarJSONImportDTO;
import org.softuni.mostwanted.domain.models.Car;
import org.softuni.mostwanted.domain.models.Racer;
import org.softuni.mostwanted.repositories.CarRepository;
import org.softuni.mostwanted.services.Racer.RacerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final RacerService racerService;

    @Autowired
    public CarServiceImpl(CarRepository carRepository,
                          RacerService racerService) {
        this.carRepository = carRepository;
        this.racerService = racerService;
    }

    @Override
    public void create(CarJSONImportDTO dto) {
        Racer racer = this.racerService.findByName(dto.getRacerName());

        if (racer == null) {
            throw new IllegalArgumentException();
        } else {

            Car car = new Car();
            car.setBrand(dto.getBrand());
            car.setModel(dto.getModel());
            car.setYearOfProduction(dto.getYearOfProduction());
            car.setPrice(dto.getPrice());
            car.setMaxSpeed(dto.getMaxSpeed());
            car.setZeroToSixty(dto.getZeroToSixty());
            car.setRacer(racer);
            racer.getCars().add(car);

            this.carRepository.saveAndFlush(car);
        }
    }

    @Override
    public Car getOneById(String carId) {
        return this.carRepository.getById(Integer.parseInt(carId));
    }

}