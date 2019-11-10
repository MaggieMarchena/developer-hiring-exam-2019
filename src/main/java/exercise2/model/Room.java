package exercise2.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Room {
    private String name;
    private String location;
    List<Booking> dayBookings;
}
