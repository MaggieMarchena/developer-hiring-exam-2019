package exercise1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(callSuper = true) @Data
public class Student extends Person{

    @ManyToMany
    @JoinTable(name = "student_subject",
            joinColumns = {
                @JoinColumn(name = "subject_id", nullable = false) },
            inverseJoinColumns = {
                @JoinColumn(name = "student_id", nullable = false) })
    private List<Subject> enrollments;

    public Student(long id, String firstName, String lastName, Date birthday) {
        super(id, firstName, lastName, birthday);
        this.enrollments = new ArrayList<>();
    }
}
