package questions.bookingSystem;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Show {
    private String showId;
    private Theater theater;
    private Timestamp startTime;
    private Timestamp endTime;
    private Movie movie;
    private Map<String, Seat> availableSeats;
    private Map<String, Seat> bookedSeats;

    Show(Theater theater, Timestamp startTime, Timestamp endTime, Movie movie) {
        this.showId = UUID.randomUUID().toString();
        this.theater = theater;
        this.startTime = startTime;
        this.endTime = endTime;
        this.movie = movie;
        this.availableSeats = new HashMap<>(theater.getSeats());
        this.bookedSeats = new HashMap<>();
    }

    public Theater getTheater() {
        return theater;
    }
    public Timestamp getStartTime() {
        return startTime;
    }
    public Timestamp getEndTime() {
        return endTime;
    }
    public Movie getMovie() {
        return movie;
    }
    public String getShowId() {
        return showId;
    }
    public void setTheater(Theater theater) {
        this.theater = theater;
    }
    public boolean removeAvailableSeat(String seatNumber) {
        Seat seat = availableSeats.remove(seatNumber);
        if (seat != null) {
            bookedSeats.put(seatNumber, seat);
            return true;
        }
        return false;
    }
    public boolean isAvailableSeat(String seatNumber) {
        return availableSeats.containsKey(seatNumber);
    }
}
