package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ships")
public class Ship extends MotorVehicle {
    private String nationality;
    private String captainName;
    private Integer sizeOfCrew;

    public Ship() {
    }

    @Basic
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Column(name = "captain_name")
    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    @Column(name = "size_of_crew")
    public Integer getSizeOfCrew() {
        return sizeOfCrew;
    }

    public void setSizeOfCrew(Integer sizeOfCrew) {
        this.sizeOfCrew = sizeOfCrew;
    }
}
