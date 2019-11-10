package exercise2.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class Room {
    private String name;
    private String location;
    List<Booking> dayBookings;

    public Room(String name, String location) {
        this.name = name;
        this.location = location;
        this.dayBookings = new ArrayList<>();
    }

    public boolean hasBookingInPeriodOfTime(LocalTime startingTime, LocalTime finishTime){
        return this.dayBookings.stream()
                .noneMatch(booking -> ((startingTime.isAfter(booking.getStartingTime()) && startingTime.isBefore(booking.getFinishTime()))
                        || (finishTime.isAfter(booking.getStartingTime()) && finishTime.isBefore(booking.getFinishTime()))));
    }

    public void addBooking(Booking booking){
        this.dayBookings.add(booking);
    }

    public void clearBooking(Booking booking){
        this.dayBookings.remove(booking);
    }

    public void startDay(){
        this.dayBookings.clear();
    }
}
