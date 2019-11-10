package exercise2.service;

import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import exercise2.model.Booking;
import exercise2.model.Room;
import lombok.Data;

@Data
public class BookingService {
    private final Duration MIN_DURATION = Duration.ofMinutes(15);
    private final Duration MAX_DURATION = Duration.ofHours(3);
    private List<Room> rooms;

    //runs every day at 00:00 with cron configuration
    public void startDay(){
        this.rooms.forEach(Room::startDay);
    }

    public void cancelBooking(Booking booking){
        this.rooms.stream()
                .filter(room -> room.getName().equals(booking.getRoom().getName()))
        .findFirst().get().clearBooking(booking);
    }

    public boolean book(String name, LocalTime startingTime, Duration duration){
        if (isDurationOk(duration)){
            LocalTime finishTime = computeFinishTime(startingTime, duration);
            List<Room> availableRooms = getAvailableRooms(startingTime, finishTime);
            if (availableRooms.isEmpty()){
                //show error in UI
                return false;
            }
            //show available rooms in UI
            Room selectedRoom = getSelectedRoom(availableRooms);
            createBooking(name, startingTime, finishTime, duration, selectedRoom);
            return true;
        }
        //show error in UI
        return false;
    }

    private Room getSelectedRoom(List<Room> availableRooms){
        Room chosenRoom = getFromUser(); //gets selection from UI
        return availableRooms.get(availableRooms.indexOf(chosenRoom));
    }

    private boolean isDurationOk(Duration duration){
        return duration.get(MINUTES) > MIN_DURATION.get(MINUTES) && duration.get(HOURS) < MAX_DURATION.get(HOURS);
    }

    private LocalTime computeFinishTime(LocalTime startingTime, Duration duration){
        return startingTime.plus(duration);
    }

    private List<Room> getAvailableRooms(LocalTime startingTime, LocalTime finishTime){
        return this.rooms.stream()
                .filter(room -> !room.hasBookingInPeriodOfTime(startingTime, finishTime))
                .collect(Collectors.toList());
    }

    private void createBooking(String name, LocalTime startingTime, LocalTime finishTime, Duration duration, Room room){
        this.rooms.get(this.rooms.indexOf(room)).addBooking(new Booking(name, startingTime, finishTime, duration, room));
    }
}
