package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.domain.dtos.binding.race.RaceWrapperXMLImportDTO;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.Race.RaceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class RaceController {

    private final RaceService raceService;
    private final Parser parser;

    public RaceController(RaceService raceService,
                               @Qualifier("XMLParser") Parser parser) {
        this.raceService = raceService;
        this.parser = parser;
    }

    public String importRaceFromXML(String xmlContent) {
        StringBuilder sb = new StringBuilder();
        try {
            RaceWrapperXMLImportDTO models = this.parser.read(RaceWrapperXMLImportDTO.class, xmlContent);

            models.getRaces().forEach(m -> {
                try {
                    Integer integer = this.raceService.create(m);
                    sb.append(String.format("Successfully imported Race - %d.", integer)).append(System.lineSeparator());
                } catch (IllegalArgumentException ignored) {
                    sb.append("Error: Invalid data.").append(System.lineSeparator());
                }
            });

        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}