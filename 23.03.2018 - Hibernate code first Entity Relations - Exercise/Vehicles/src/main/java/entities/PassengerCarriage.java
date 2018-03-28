package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "Passenger Carriage")
public class PassengerCarriage extends Carriage {
    private Integer standingPassengersCapacity;

    public PassengerCarriage() {
    }

    @Column(name = "standing_passengers_capacity")
    public Integer getStandingPassengersCapacity() {
        return standingPassengersCapacity;
    }

    public void setStandingPassengersCapacity(Integer standingPassengersCapacity) {
        this.standingPassengersCapacity = standingPassengersCapacity;
    }
}
