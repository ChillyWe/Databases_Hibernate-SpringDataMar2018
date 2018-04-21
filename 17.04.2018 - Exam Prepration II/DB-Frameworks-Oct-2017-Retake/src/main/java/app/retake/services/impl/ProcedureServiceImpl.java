package app.retake.services.impl;

import app.retake.domain.dto.ProcedureAnimalAidXMLExportDTO;
import app.retake.domain.dto.ProcedureWrapperXMLExportDTO;
import app.retake.domain.dto.ProcedureXMLExportDTO;
import app.retake.domain.dto.ProcedureXMLImportDTO;
import app.retake.domain.models.Animal;
import app.retake.domain.models.AnimalAid;
import app.retake.domain.models.Procedure;
import app.retake.domain.models.Vet;
import app.retake.repositories.ProcedureRepository;
import app.retake.services.api.AnimalAidService;
import app.retake.services.api.AnimalService;
import app.retake.services.api.ProcedureService;
import app.retake.services.api.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProcedureServiceImpl implements ProcedureService {

    private final ProcedureRepository procedureRepository;
    private final VetService vetService;
    private final AnimalService animalService;
    private final AnimalAidService animalAidService;

    @Autowired
    public ProcedureServiceImpl(ProcedureRepository procedureRepository,
                                VetService vetService,
                                AnimalService animalService,
                                AnimalAidService animalAidService) {
        this.procedureRepository = procedureRepository;
        this.vetService = vetService;
        this.animalService = animalService;
        this.animalAidService = animalAidService;
    }

    @Override
    public void create(ProcedureXMLImportDTO dto){
        Vet vet = this.vetService.findByName(dto.getVet());
        Animal animal = this.animalService.findBySerialNumber(dto.getAnimal());
        if (vet == null || animal == null) {
            throw new IllegalArgumentException();
        } else {
            Set<AnimalAid> animalAids = dto.getAnimalAids()
                    .stream()
                    .map(animalAidDto -> {
                        AnimalAid aid = this.animalAidService.getOneByName(animalAidDto.getName());
                        if (aid == null) throw new IllegalArgumentException();
                        return aid;
                    }).collect(Collectors.toSet());
            Procedure procedure = new Procedure();
            procedure.setAnimal(animal);
            procedure.setVet(vet);
            procedure.setDatePerformed(dto.getDate());
            procedure.setAnimalAids(animalAids);
            this.procedureRepository.saveAndFlush(procedure);
        }
    }

    @Override
    public ProcedureWrapperXMLExportDTO exportProcedures() {
        List<Procedure> allProcedures = this.procedureRepository.findAll();

        Set<ProcedureXMLExportDTO> procedureXMLExportDTO = allProcedures.stream().map(procedure -> {
            String serialNumber = procedure.getAnimal().getPassport().getSerialNumber();
            String ownerName = procedure.getAnimal().getPassport().getOwnerPhoneNumber();
            Set<ProcedureAnimalAidXMLExportDTO> animalAids = procedure.getAnimalAids()
                    .stream()
                    .map(animalAid -> new ProcedureAnimalAidXMLExportDTO(animalAid.getName(), animalAid.getPrice()))
                    .collect(Collectors.toSet());

            ProcedureXMLExportDTO dto = new ProcedureXMLExportDTO(serialNumber, ownerName, animalAids);
            return dto;
        }).collect(Collectors.toSet());

        return new ProcedureWrapperXMLExportDTO(procedureXMLExportDTO);
    }
}