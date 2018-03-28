package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="students")
//@DiscriminatorValue(value = "Student")
@PrimaryKeyJoinColumn(name="id")
public class Student extends BasicHuman {
    private Double averageGrade;
    private Double attendance;
    private Set<Course> courses;

    public Student() {
    }

    @Column(name = "average_grade")
    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Basic
    public Double getAttendance() {
        return attendance;
    }

    public void setAttendance(Double attendance) {
        this.attendance = attendance;
    }

    @ManyToMany(mappedBy = "students")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
