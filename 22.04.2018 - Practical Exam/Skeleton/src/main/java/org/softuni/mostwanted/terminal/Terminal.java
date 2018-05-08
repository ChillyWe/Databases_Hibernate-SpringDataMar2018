package org.softuni.mostwanted.terminal;

import org.softuni.mostwanted.constants.Config;
import org.softuni.mostwanted.controllers.*;
import org.softuni.mostwanted.io.interfaces.ConsoleIO;
import org.softuni.mostwanted.io.interfaces.FileIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Terminal implements CommandLineRunner {

    private final TownController townController;
    private final DistrictController districtController;
    private final RacerController racerController;
    private final CarController carController;
    private final RaceEntryController raceEntryController;
    private final RaceController raceController;

    private final ConsoleIO consoleIO;
    private final FileIO fileIO;

    @Autowired
    public Terminal(TownController townController,
                    DistrictController districtController,
                    RacerController racerController,
                    CarController carController,
                    RaceEntryController raceEntryController,
                    RaceController raceController,
                    ConsoleIO consoleIO,
                    FileIO fileIO) {
        this.townController = townController;
        this.districtController = districtController;
        this.racerController = racerController;
        this.carController = carController;
        this.raceEntryController = raceEntryController;
        this.raceController = raceController;
        this.consoleIO = consoleIO;
        this.fileIO = fileIO;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedTowns();
        this.seedDistricts();
        this.seedRacers();
        this.seedCars();
        this.seedRaceEntries();
        this.seedRaces();

        this.exportTowns();
        this.exportRacingCars();
    }

    private void exportRacingCars() {
        String result = this.racerController.exportRacersWithCars();
        try {
            this.fileIO.write(result, "racingCars.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportTowns() {
        String result = this.townController.exportTownsWithRacers();
        try {
            this.fileIO.write(result, "racingTowns.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void seedRaces() {
        try {
            String resultFromParsing = this.raceController.importRaceFromXML(fileIO.read(Config.RACE_IMPORT_XML));
            this.consoleIO.write(resultFromParsing);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void seedRaceEntries() {
        try {
            String resultFromParsing = this.raceEntryController.importRaceEntriesFromXML(fileIO.read(Config.RACE_ENTRIES_IMPORT_XML));
            this.consoleIO.write(resultFromParsing);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void seedCars() {
        try {
            String resultFromParsing = this.carController.importCarsFromJSON(fileIO.read(Config.CARS_IMPORT_JSON));
            this.consoleIO.write(resultFromParsing);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void seedRacers() {
        try {
            String resultFromParsing = this.racerController.importRacersFromJSON(fileIO.read(Config.RACERS_IMPORT_JSON));
            this.consoleIO.write(resultFromParsing);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void seedDistricts() {
        try {
            String resultFromParsing = this.districtController.importDistrictFromJSON(fileIO.read(Config.DISTRICTS_IMPORT_JSON));
            this.consoleIO.write(resultFromParsing);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void seedTowns() {
        try {
            String resultFromParsing = this.townController.importTownsFromJSON(fileIO.read(Config.TOWNS_IMPORT_JSON));
            this.consoleIO.write(resultFromParsing);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}