package questions.bookingSystem;

public class Ticket {
    private Booking booking;

    public Ticket(Booking booking) {
        this.booking = booking;
    }

    public Booking getBooking() {
        return booking;
    }
}
