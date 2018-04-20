package app.retake.controllers;

import app.retake.domain.dto.AnimalJSONImportDTO;
import app.retake.parser.ValidationUtil;
import app.retake.parser.interfaces.Parser;
import app.retake.services.api.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class AnimalController {

    private final Parser parser;
    private final AnimalService animalService;

    @Autowired
    public AnimalController(@Qualifier("JSONParser") Parser parser,
                            AnimalService animalService) {
        this.parser = parser;
        this.animalService = animalService;
    }

    public String importDataFromJSON(String jsonContent) {
        StringBuilder sb = new StringBuilder();
        try {
            AnimalJSONImportDTO[] models = this.parser.read(AnimalJSONImportDTO[].class, jsonContent);
            Arrays.stream(models).forEach(m -> {
                if (ValidationUtil.isValid(m)) {
                    try {
                        this.animalService.create(m);
                        sb.append(String.format("Record %s Passport №: %s successfully imported.",
                                m.getName(), m.getPassport().getSerialNumber()))
                                .append(System.lineSeparator());
                    } catch (IllegalArgumentException e) {
                        sb.append("Error: Invalid data.").append(System.lineSeparator());
                    }
                } else {
                    sb.append("Error: Invalid data.").append(System.lineSeparator());
                }
            });
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String exportAnimalsByOwnerPhoneNumber(String phoneNumber) {
        return null;
    }
}