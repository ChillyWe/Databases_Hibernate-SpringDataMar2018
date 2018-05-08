package org.softuni.mostwanted.domain.dtos.views;


import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class RacingTownsJSONExportDTO implements Serializable {

    @Expose
    private String name;
    @Expose
    private Integer racers;

    public RacingTownsJSONExportDTO() {
    }

    public RacingTownsJSONExportDTO(String name, Integer racers) {
        this.name = name;
        this.racers = racers;
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