package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.domain.dtos.binding.DistrictJSONImportDTO;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.District.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class DistrictController {
    private final DistrictService districtService;
    private final Parser parser;

    @Autowired
    public DistrictController(DistrictService districtService,
                              @Qualifier("JSONParser") Parser parser) {
        this.districtService = districtService;
        this.parser = parser;
    }

    public String importDistrictFromJSON(String jsonContent) {
        StringBuilder sb = new StringBuilder();
        try {
            DistrictJSONImportDTO[] models = this.parser.read(DistrictJSONImportDTO[].class, jsonContent);
            Arrays.stream(models).forEach(m -> {
                if (ValidationUtil.isValid(m)) {
                    try {
                        this.districtService.create(m);
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