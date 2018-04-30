package org.softuni.mostwanted.services.Car;

import org.softuni.mostwanted.domain.dtos.binding.CarJSONImportDTO;
import org.softuni.mostwanted.domain.models.Car;

public interface CarService {

    void create(CarJSONImportDTO dto);

    Car getOneById(String carId);
}