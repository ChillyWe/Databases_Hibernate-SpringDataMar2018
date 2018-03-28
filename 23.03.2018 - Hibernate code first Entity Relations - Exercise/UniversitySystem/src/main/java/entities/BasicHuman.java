package entities;

import javax.persistence.*;

@Entity
@Table(name="people")
//@DiscriminatorColumn(name="kind",discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BasicHuman implements Human {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public BasicHuman() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    @Column(name = "first_name")
    public String getFirstName() {
        return null;
    }

    @Override
    @Column(name = "last_name")
    public String getLastName() {
        return null;
    }

    @Override
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return null;
    }
}
