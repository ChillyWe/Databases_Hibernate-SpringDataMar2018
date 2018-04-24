package org.softuni.mostwanted.domain.dtos.binding;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;

public class TownJSONImportDTO {

    @Expose
    @NotNull
    private String name;

    public TownJSONImportDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}