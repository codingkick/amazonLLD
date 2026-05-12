package questions.bookingSystem;

public class Booking {
    private User user;
    private String bookingDate;
    private Theater theater;
    private Show show;
    private String seatNumber;

    public Booking(User user, String bookingDate, Theater theater, Show show, String seatNumber) {
        this.user = user;
        this.bookingDate = bookingDate;
        this.theater = theater;
        this.show = show;
        this.seatNumber = seatNumber;
    }

    public User getUser() {
        return user;
    }
    public String getBookingDate() {
        return bookingDate;
    }
    public Theater getTheater() {
        return theater;
    }
    public Show getShow() {
        return show;
    }
    public String getSeatNumber() {
        return seatNumber;
    }
}
