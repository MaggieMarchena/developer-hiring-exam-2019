package model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true) @Data
public class Janitor extends Employee{
    private String workingArea;
}
