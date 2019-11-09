package model;

import java.util.Date;

import lombok.Data;

@Data
public abstract class Person {
    private long id;
    private String name;
    private String lastName;
    private Date birthday;
}
