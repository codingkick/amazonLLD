package questions.bookingSystem;

import java.time.Instant;

public class BookingManager {
    private final SeatLockService seatLockService;
    private final PaymentService paymentService;

    public BookingManager(SeatLockService seatLockService, PaymentService paymentService) {
        this.seatLockService = seatLockService;
        this.paymentService = paymentService;
    }

    public BookingManager() {
        this(new SeatLockService(), new PaymentService());
    }

    public Booking createBooking(User user, Show show, String seatNumber) {
        if(!show.isAvailableSeat(seatNumber)) {
            throw new RuntimeException("Seat is not available");
        }
        boolean locked = seatLockService.tryLockSeat(user, show, seatNumber);
        if (!locked) {
            throw new RuntimeException("Seat is already locked");
        }

        Booking booking = new Booking(user, Instant.now().toString(), show.getTheater(), show, seatNumber);
        // save booking to database or persistence store
        return booking;
    }

    public Ticket makePayment(Booking booking) {
        if (!seatLockService.isLockedByUser(booking.getShow(), booking.getSeatNumber(), booking.getUser())) {
            throw new RuntimeException("Seat is not locked by the user");
        }
        else {
            return paymentService.processPayment(booking);
        }
    }
}
