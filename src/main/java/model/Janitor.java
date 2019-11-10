package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "janitors")
@EqualsAndHashCode(callSuper = true) @Data
public class Janitor extends Employee{
    private String workingArea;

    public Janitor(long id, String firstName, String lastName, Date birthday, String workingArea) {
        super(id, firstName, lastName, birthday);
        this.workingArea = workingArea;
    }
}
