package org.softuni.mostwanted.services.Car;

import org.softuni.mostwanted.domain.dtos.binding.CarJSONImportDTO;

public interface CarService {

    void create(CarJSONImportDTO dto);
}