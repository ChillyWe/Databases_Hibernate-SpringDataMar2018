package org.softuni.mostwanted.domain.dtos.binding;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;

public class DistrictJSONImportDTO {

    @Expose
    @NotNull
    private String name;
    @Expose
    private String townName;

    public DistrictJSONImportDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
}