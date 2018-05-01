package org.softuni.mostwanted.domain.dtos.views;


public class RacingTownsJSONExportDTO {

    private String name;
    private Integer racers;

    public RacingTownsJSONExportDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRacers() {
        return racers;
    }

    public void setRacers(Integer racers) {
        this.racers = racers;
    }
}