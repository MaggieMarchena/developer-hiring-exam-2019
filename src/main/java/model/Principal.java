package model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true) @Data
public class Principal extends Employee implements HighTierEmployee{
}
