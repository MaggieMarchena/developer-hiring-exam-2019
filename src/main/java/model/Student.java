package model;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true) @Data
public class Student extends Person{
    private List<String> enrollments;
}
