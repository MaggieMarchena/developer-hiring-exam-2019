package exercise1.model;

import java.util.Date;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(callSuper = true) @Data
public class Principal extends Employee implements HighTierEmployee{
    public Principal(long id, String firstName, String lastName, Date birthday) {
        super(id, firstName, lastName, birthday);
    }
}
