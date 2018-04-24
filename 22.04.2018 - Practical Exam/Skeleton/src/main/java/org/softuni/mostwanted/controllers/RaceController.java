package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.Race.RaceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class RaceController {

    private final RaceService raceService;
    private final Parser parser;

    public RaceController(RaceService raceService,
                               @Qualifier("XMLParser") Parser parser) {
        this.raceService = raceService;
        this.parser = parser;
    }
}