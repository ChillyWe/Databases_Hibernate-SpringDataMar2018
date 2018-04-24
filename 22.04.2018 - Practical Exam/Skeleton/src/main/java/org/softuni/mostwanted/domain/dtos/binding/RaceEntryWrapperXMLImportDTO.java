package org.softuni.mostwanted.domain.dtos.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "race-entries")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceEntryWrapperXMLImportDTO {

    @XmlElement(name = "race-entries")
    private Set<RaceEntryXMLImportDTO> raceEntry;

    public RaceEntryWrapperXMLImportDTO() {
        this.raceEntry = new HashSet<>();
    }

    public Set<RaceEntryXMLImportDTO> getRaceEntry() {
        return raceEntry;
    }

    public void setRaceEntry(Set<RaceEntryXMLImportDTO> raceEntry) {
        this.raceEntry = raceEntry;
    }
}