package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "Sleeping Carriage")
public class SleepingCarriage extends Carriage {
    private Integer bedsCount;

    public SleepingCarriage() {
    }

    @Column(name = "beds_count")
    public Integer getBedsCount() {
        return bedsCount;
    }

    public void setBedsCount(Integer bedsCount) {
        this.bedsCount = bedsCount;
    }
}
