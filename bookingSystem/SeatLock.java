package questions.bookingSystem;

import java.time.Instant;

public class SeatLock {
    private User user;
    private Instant lockedUpto;
    SeatLock(User user, Instant lockedUpto) {
        this.user = user;
        this.lockedUpto = lockedUpto;
    }
    public User getUser() {
        return user;
    }
    public Instant getLockedUpto() {
        return lockedUpto;
    }
}
