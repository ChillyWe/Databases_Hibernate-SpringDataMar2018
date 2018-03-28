package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue(value = "Restaurant Carriage")
public class RestaurantCarriage extends Carriage {
    private Integer tableCount;

    public RestaurantCarriage() {
    }

    @Column(name = "table_count")
    public Integer getTableCount() {
        return tableCount;
    }

    public void setTableCount(Integer tableCount) {
        this.tableCount = tableCount;
    }
}
