package org.softuni.mostwanted.services.Town;

import org.softuni.mostwanted.domain.dtos.binding.TownJSONImportDTO;
import org.softuni.mostwanted.domain.models.Town;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final ModelParser parser;

    @Autowired
    public TownServiceImpl(TownRepository townRepository,
                           ModelParser parser) {
        this.townRepository = townRepository;
        this.parser = parser;
    }

    @Override
    public void create(TownJSONImportDTO dto) {
        Town town = this.townRepository.findByName(dto.getName());

        if (town != null) {
            throw new IllegalArgumentException();
        } else {
            this.townRepository.saveAndFlush(this.parser.convert(dto, Town.class));
        }
    }

    @Override
    public Town findByName(String name) {
        return this.townRepository.findByName(name);
    }

    @Override
    public List<Town> findAll() {
        return this.townRepository.findAll();
    }
}