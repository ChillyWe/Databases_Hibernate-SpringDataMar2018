package org.softuni.mostwanted.domain.dtos.binding.race;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "race")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceXMLImportDTO {

    @XmlElement(name = "laps")
    private Integer laps;
    @XmlElement(name = "district-name")
    private String districtName;
    @XmlElementWrapper(name = "entries")
    @XmlElement(name = "entry")
    private List<Integer> raceEntries;

    public RaceXMLImportDTO() {
    }

    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public List<Integer> getRaceEntries() {
        return raceEntries;
    }

    public void setRaceEntries(List<Integer> raceEntries) {
        this.raceEntries = raceEntries;
    }
}