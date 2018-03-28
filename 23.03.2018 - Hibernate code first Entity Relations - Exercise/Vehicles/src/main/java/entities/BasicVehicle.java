package entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="vehicles")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BasicVehicle implements Vehicle {

    private Long id;
    private String manufacturer;
    private String model;
    private BigDecimal price;
    private Integer maxSpeed;

    public BasicVehicle() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    @Basic
    public String getManufacturer() {
        return null;
    }

    @Override
    @Basic
    public String getModel() {
        return null;
    }

    @Override
    @Basic
    public BigDecimal getPrice() {
        return null;
    }

    @Override
    @Column(name="max_speed")
    public Integer getMaxSpeed() {
        return null;
    }
}
