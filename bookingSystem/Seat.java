package questions.bookingSystem;

public class Seat {
    private String seatNumber;
    private SeatType seatType;
    public Seat(String seatNumber, SeatType seatType) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }
    public String getSeatNumber() {
        return seatNumber;
    }
    public SeatType getSeatType() {
        return seatType;
    }
}
