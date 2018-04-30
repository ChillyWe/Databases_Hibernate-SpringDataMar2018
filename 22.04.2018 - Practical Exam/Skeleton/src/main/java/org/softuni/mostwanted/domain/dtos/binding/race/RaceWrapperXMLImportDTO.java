package org.softuni.mostwanted.domain.dtos.binding.race;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name = "races")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceWrapperXMLImportDTO {

    @XmlElement(name = "race")
    private Set<RaceXMLImportDTO> races;

    public RaceWrapperXMLImportDTO() {
    }

    public Set<RaceXMLImportDTO> getRaces() {
        return races;
    }

    public void setRaces(Set<RaceXMLImportDTO> races) {
        this.races = races;
    }
}