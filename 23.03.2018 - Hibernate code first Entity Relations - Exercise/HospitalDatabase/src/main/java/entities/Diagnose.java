package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="diagnoses")
public class Diagnose {
   private Long id;
   private String name;
   private String comments;
   private Set<Patient> patients;

    public Diagnose() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(columnDefinition = "TEXT")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @ManyToMany
    @JoinTable(name="patients_diagnoses",
    joinColumns = @JoinColumn(name ="diagnose_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="patient_id", referencedColumnName = "id"))
    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
