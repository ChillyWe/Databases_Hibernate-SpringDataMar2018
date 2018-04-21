package app.retake.domain.dto;


import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcedureXMLExportDTO {

    @XmlAttribute(name = "animal-passport")
    private String animalPassport;
    @XmlElement(name = "owner")
    private String owner;
    @XmlElementWrapper(name = "animal-aids")
    @XmlElement(name = "animal-aid")
    private Set<ProcedureAnimalAidXMLExportDTO> procedureAnimalAids;

    public ProcedureXMLExportDTO() {
    }

    public ProcedureXMLExportDTO(String animalPassport, String owner, Set<ProcedureAnimalAidXMLExportDTO> procedureAnimalAids) {
        this.animalPassport = animalPassport;
        this.owner = owner;
        this.procedureAnimalAids = procedureAnimalAids;
    }

    public String getAnimalPassport() {
        return animalPassport;
    }

    public void setAnimalPassport(String animalPassport) {
        this.animalPassport = animalPassport;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Set<ProcedureAnimalAidXMLExportDTO> getProcedureAnimalAids() {
        return procedureAnimalAids;
    }

    public void setProcedureAnimalAids(Set<ProcedureAnimalAidXMLExportDTO> procedureAnimalAids) {
        this.procedureAnimalAids = procedureAnimalAids;
    }
}