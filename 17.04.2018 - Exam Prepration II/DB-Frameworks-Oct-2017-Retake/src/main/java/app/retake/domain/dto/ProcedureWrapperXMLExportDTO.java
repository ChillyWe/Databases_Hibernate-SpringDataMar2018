package app.retake.domain.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "procedures")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcedureWrapperXMLExportDTO {

    private Set<ProcedureXMLExportDTO> procedures;

    public ProcedureWrapperXMLExportDTO() {
        this.procedures = new HashSet<>();
    }

    public ProcedureWrapperXMLExportDTO(Set<ProcedureXMLExportDTO> procedures) {
        this.procedures = procedures;
    }

    public Set<ProcedureXMLExportDTO> getProcedures() {
        return procedures;
    }

    public void setProcedures(Set<ProcedureXMLExportDTO> procedures) {
        this.procedures = procedures;
    }
}