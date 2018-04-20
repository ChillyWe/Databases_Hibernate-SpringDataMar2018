package app.retake;

import app.retake.controllers.AnimalAidController;
import app.retake.controllers.AnimalController;
import app.retake.controllers.ProcedureController;
import app.retake.controllers.VetController;
import app.retake.io.api.ConsoleIO;
import app.retake.io.api.FileIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Terminal implements CommandLineRunner {

    private AnimalAidController animalAidController;
    private AnimalController animalController;
    private ProcedureController procedureController;
    private VetController vetController;
    private ConsoleIO consoleIO;
    private FileIO fileIO;

    @Autowired
    public Terminal(AnimalAidController animalAidController,
                    AnimalController animalController,
                    ProcedureController procedureController,
                    VetController vetController,
                    ConsoleIO consoleIO,
                    FileIO fileIO) {
        this.animalAidController = animalAidController;
        this.animalController = animalController;
        this.procedureController = procedureController;
        this.vetController = vetController;
        this.consoleIO = consoleIO;
        this.fileIO = fileIO;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.seedAnimalAids();
        this.seedAnimals();
        this.seedVets();
        this.seedProcedures();


    }

    private void seedProcedures() {
        try {
            String resultFromParsing = this.procedureController.importDataFromXML(fileIO.read(Config.PROCEDURES_IMPORT_XML));
            this.consoleIO.write(resultFromParsing);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void seedVets() {
        try {
            String resultFromParsing = this.vetController.importDataFromXML(fileIO.read(Config.VETS_IMPORT_XML));
            this.consoleIO.write(resultFromParsing);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void seedAnimalAids() {
        try {
            String resultFromParsing = this.animalAidController.importDataFromJSON(fileIO.read(Config.ANIMAL_AIDS_IMPORT_JSON));
            this.consoleIO.write(resultFromParsing);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void seedAnimals() {
        try {
            String resultFromParsing = this.animalController.importDataFromJSON(fileIO.read(Config.ANIMALS_IMPORT_JSON));
            this.consoleIO.write(resultFromParsing);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
