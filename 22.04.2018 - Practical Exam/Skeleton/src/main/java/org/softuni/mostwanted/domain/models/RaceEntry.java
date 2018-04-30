package org.softuni.mostwanted.domain.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "race_entries")
public class RaceEntry {

    private Integer id;
    private boolean hasFinished;
    private BigDecimal finishTime;
    private Car car;
    private Racer racer;

    private Race race;

    public RaceEntry() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "has_finished")
    public boolean isHasFinished() {
        return hasFinished;
    }

    public void setHasFinished(boolean hasFinished) {
        this.hasFinished = hasFinished;
    }

    public BigDecimal getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(BigDecimal finishTime) {
        this.finishTime = finishTime;
    }

    @ManyToOne
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne
    public Racer getRacer() {
        return racer;
    }

    public void setRacer(Racer racer) {
        this.racer = racer;
    }

    @ManyToOne
    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}