package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.domain.dtos.binding.TownJSONImportDTO;
import org.softuni.mostwanted.domain.dtos.views.RacingTownsJSONExportDTO;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.Town.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TownController {

    private final TownService townService;
    private final Parser parser;

    @Autowired
    public TownController(TownService townService,
                          @Qualifier("JSONParser") Parser parser) {
        this.townService = townService;
        this.parser = parser;
    }

    public String importTownsFromJSON(String jsonContent) {
        StringBuilder sb = new StringBuilder();
        try {
            TownJSONImportDTO[] models = this.parser.read(TownJSONImportDTO[].class, jsonContent);
            Arrays.stream(models).forEach(m -> {
                if (ValidationUtil.isValid(m)) {
                    try {
                        this.townService.create(m);
                        sb.append(String.format("Successfully imported Town - %s.", m.getName())).append(System.lineSeparator());
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

    public String exportTownsWithRacers() {
        try {
            List<RacingTownsJSONExportDTO> models = this.townService.findAll()
                    .stream().map(town -> {
                int size = town.getRacers().size();
                return new RacingTownsJSONExportDTO(town.getName(), size);
            }).collect(Collectors.toList());

            return this.parser.write(models.stream()
                    .sorted(Comparator.comparingInt(RacingTownsJSONExportDTO::getRacers).reversed()
                            .thenComparing(RacingTownsJSONExportDTO::getName)).collect(Collectors.toList()));
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
