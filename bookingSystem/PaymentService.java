package questions.bookingSystem;

public class PaymentService {
    public Ticket processPayment(Booking booking) {
        // In a real system this would call a payment gateway and create a payment record.
        booking.getShow().removeAvailableSeat(booking.getSeatNumber());
        return new Ticket(booking);
    }
}
