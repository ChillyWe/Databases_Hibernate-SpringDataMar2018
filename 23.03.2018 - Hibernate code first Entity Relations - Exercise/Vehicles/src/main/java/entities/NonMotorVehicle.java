package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="non_motor_vehicles")
public abstract class NonMotorVehicle extends BasicVehicle {

    public NonMotorVehicle() {
    }
}
