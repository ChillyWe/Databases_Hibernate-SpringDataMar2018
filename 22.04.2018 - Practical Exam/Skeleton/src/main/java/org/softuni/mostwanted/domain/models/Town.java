package org.softuni.mostwanted.domain.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town {

    private Integer id;
    private String name;

    private Set<District> district;
    private Set<Racer> racers;

    public Town() {
        this.district = new HashSet<>();
        this.racers = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "town", cascade = CascadeType.ALL)
    public Set<District> getDistrict() {
        return district;
    }

    public void setDistrict(Set<District> district) {
        this.district = district;
    }

    @OneToMany(mappedBy = "homeTown", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Racer> getRacers() {
        return racers;
    }

    public void setRacers(Set<Racer> racers) {
        this.racers = racers;
    }
}