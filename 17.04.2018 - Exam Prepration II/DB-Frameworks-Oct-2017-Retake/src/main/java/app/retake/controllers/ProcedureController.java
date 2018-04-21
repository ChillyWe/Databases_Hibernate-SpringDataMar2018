package app.retake.controllers;

import app.retake.domain.dto.ProcedureWrapperXMLImportDTO;
import app.retake.parser.interfaces.Parser;
import app.retake.services.api.ProcedureService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class ProcedureController {

    private final Parser parser;
    private final ProcedureService procedureService;

    public ProcedureController(@Qualifier("XMLParser") Parser parser,
                               ProcedureService procedureService) {
        this.parser = parser;
        this.procedureService = procedureService;
    }

    public String importDataFromXML(String xmlContent){

        StringBuilder sb = new StringBuilder();
        try {
            ProcedureWrapperXMLImportDTO models = this.parser.read(ProcedureWrapperXMLImportDTO.class, xmlContent);
            models.getProcedures().forEach(m -> {
                    try {
                        this.procedureService.create(m);
                        sb.append("Record successfully imported.").append(System.lineSeparator());
                    } catch (IllegalArgumentException e) {
                        sb.append("Error: Invalid data.").append(System.lineSeparator());
                    }
            });
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String exportProcedures() throws IOException, JAXBException {
        return this.parser.write(this.procedureService.exportProcedures());
    }
}