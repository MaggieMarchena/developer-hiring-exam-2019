package exercise2.model;

import java.time.Duration;
import java.time.LocalTime;

import lombok.Data;

@Data
public class Booking {

    private String name;
    private LocalTime startingTime;
    private Duration duration;
    private LocalTime finishTime;
    private Room room;

    public Booking(String name, LocalTime startingTime, LocalTime finishTime, Duration duration, Room room) {
        this.name = name;
        this.startingTime = startingTime;
        this.duration = duration;
        this.finishTime = finishTime;
        this.room = room;
    }
}
