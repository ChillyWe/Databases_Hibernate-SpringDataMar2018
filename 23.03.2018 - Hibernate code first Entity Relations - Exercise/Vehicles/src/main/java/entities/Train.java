package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "trains")
public class Train extends MotorVehicle {
    private Locomotive locomotive;
    private Integer numberOfCarriages;
    private Set<Carriage> carriages;

    public Train() {
    }

    @OneToOne
    @JoinColumn(name="locomotive_id", referencedColumnName = "id")
    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    @Column(name="number_of_carriages")
    public Integer getNumberOfCarriages() {
        return numberOfCarriages;
    }

    public void setNumberOfCarriages(Integer numberOfCarriages) {
        this.numberOfCarriages = numberOfCarriages;
    }

    @OneToMany(mappedBy = "train")
    public Set<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(Set<Carriage> carriages) {
        this.carriages = carriages;
    }
}
