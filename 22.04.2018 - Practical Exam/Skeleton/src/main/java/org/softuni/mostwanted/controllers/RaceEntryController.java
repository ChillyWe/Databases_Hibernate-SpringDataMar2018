package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.domain.dtos.binding.RaceEntryWrapperXMLImportDTO;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.RaceEntry.RaceEntryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class RaceEntryController {

    private final RaceEntryService raceEntryService;
    private final Parser parser;

    public RaceEntryController(RaceEntryService raceEntryService,
                               @Qualifier("XMLParser") Parser parser) {
        this.raceEntryService = raceEntryService;
        this.parser = parser;
    }

    public String importRaceEntriesFromXML(String xmlContent) {
        StringBuilder sb = new StringBuilder();
        try {
            RaceEntryWrapperXMLImportDTO models = this.parser.read(RaceEntryWrapperXMLImportDTO.class, xmlContent);

            String debug = "";
            models.getRaceEntry().forEach(m -> {
                try {
                    this.raceEntryService.create(m);
                    int i = 0;
                    sb.append(String.format("Successfully imported RaceEntry - %d.", i++)).append(System.lineSeparator());
                } catch (IllegalArgumentException ignored) {
                    sb.append("Error: Duplicate Data!").append(System.lineSeparator());
                }
                sb.append("Error: Invalid data.").append(System.lineSeparator());

            });

        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}