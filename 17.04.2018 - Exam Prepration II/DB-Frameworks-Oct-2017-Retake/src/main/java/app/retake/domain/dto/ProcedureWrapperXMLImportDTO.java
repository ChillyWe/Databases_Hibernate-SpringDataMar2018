package app.retake.domain.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "procedures")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcedureWrapperXMLImportDTO {

    @XmlElement(name = "procedures")
    private Set<ProcedureXMLImportDTO> procedures;

    public ProcedureWrapperXMLImportDTO() {
        this.procedures = new HashSet<>();
    }

    public Set<ProcedureXMLImportDTO> getProcedures() {
        return procedures;
    }

    public void setProcedures(Set<ProcedureXMLImportDTO> procedures) {
        this.procedures = procedures;
    }
}