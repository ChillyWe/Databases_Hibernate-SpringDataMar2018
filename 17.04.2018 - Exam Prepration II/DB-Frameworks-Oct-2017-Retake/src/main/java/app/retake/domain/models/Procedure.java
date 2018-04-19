package app.retake.domain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "procedures")
public class Procedure implements Serializable {
    private Integer id;
    private Animal animal;
    private Vet vet;
    private Date datePerformed;
    private Set<AnimalAid> animalAids;

    public Procedure() {
        this.animalAids = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Transient
    public BigDecimal getCost() {
        BigDecimal cost = BigDecimal.ZERO;
        for (AnimalAid service : this.animalAids) {
            cost = cost.add(service.getPrice());
        }
        return cost;
    }

    @ManyToOne
    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public Date getDatePerformed() {
        return datePerformed;
    }

    public void setDatePerformed(Date datePerformed) {
        this.datePerformed = datePerformed;
    }

    @ManyToMany
    public Set<AnimalAid> getAnimalAids() {
        return animalAids;
    }

    public void setAnimalAids(Set<AnimalAid> animalAids) {
        this.animalAids = animalAids;
    }
}