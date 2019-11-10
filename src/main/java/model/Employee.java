package model;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@EqualsAndHashCode(callSuper = true) @Data
public abstract class Employee extends Person{
    public Employee(long id, String firstName, String lastName, Date birthday) {
        super(id, firstName, lastName, birthday);
    }
}
