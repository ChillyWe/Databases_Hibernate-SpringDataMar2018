package org.softuni.mostwanted.domain.dtos.binding.raceEntry;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceEntryModelForXMLRaceParseDTO {

    @XmlAttribute(name = "id")
    private Integer id;

    public RaceEntryModelForXMLRaceParseDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}