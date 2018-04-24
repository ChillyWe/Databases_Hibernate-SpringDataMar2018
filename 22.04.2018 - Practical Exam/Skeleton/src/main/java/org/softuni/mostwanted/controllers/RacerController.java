package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.domain.dtos.binding.RacerJSONImportDTO;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.Racer.RacerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class RacerController {

    private final RacerService racerService;
    private final Parser parser;

    public RacerController(RacerService racerService,
                           @Qualifier("JSONParser") Parser parser) {
        this.racerService = racerService;
        this.parser = parser;
    }

    public String importRacersFromJSON(String jsonContent) {
        StringBuilder sb = new StringBuilder();
        try {
            RacerJSONImportDTO[] models = this.parser.read(RacerJSONImportDTO[].class, jsonContent);
            Arrays.stream(models).forEach(m -> {
                if (ValidationUtil.isValid(m)) {
                    try {
                        this.racerService.create(m);
                        sb.append(String.format("Successfully imported District - %s.", m.getName())).append(System.lineSeparator());
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