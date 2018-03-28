package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cargo_ships")
public class CargoShip extends Ship {
    private Integer maxLoadKg;

    public CargoShip() {
    }

    @Column(name = "max_load_kg")
    public Integer getMaxLoadKg() {
        return maxLoadKg;
    }

    public void setMaxLoadKg(Integer maxLoadKg) {
        this.maxLoadKg = maxLoadKg;
    }
}
