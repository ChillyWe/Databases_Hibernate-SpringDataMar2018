package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.domain.dtos.binding.CarJSONImportDTO;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.Car.CarService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class CarController {
    private final CarService carService;
    private final Parser parser;

    public CarController(CarService carService,
                         @Qualifier("JSONParser") Parser parser) {
        this.carService = carService;
        this.parser = parser;
    }

    public String importCarsFromJSON(String jsonContent) {
        StringBuilder sb = new StringBuilder();
        try {
            CarJSONImportDTO[] models = this.parser.read(CarJSONImportDTO[].class, jsonContent);
            Arrays.stream(models).forEach(m -> {
                if (ValidationUtil.isValid(m)) {
                    try {
                        this.carService.create(m);
                        sb.append(String.format("Successfully imported Car - %s %s @ %d.",
                                m.getBrand(), m.getModel(), m.getYearOfProduction())).append(System.lineSeparator());
                    } catch (IllegalArgumentException ignored) {
                        sb.append("Error: Duplicate Data!").append(System.lineSeparator());
                    }
                } else {
                    sb.append("Error: Invalid data.").append(System.lineSeparator());
                }
            });
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}