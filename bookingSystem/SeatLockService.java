package questions.bookingSystem;

import java.time.Instant;
import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SeatLockService {
    private final ConcurrentHashMap<String, SeatLock> seatLocks = new ConcurrentHashMap<>();
    private final Duration lockDuration;

    public SeatLockService(Duration lockDuration) {
        this.lockDuration = lockDuration;
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(()->{
            seatLocks.values().removeIf((v)->{
                return v.getLockedUpto().isBefore(Instant.now());
            });
        },30,30, TimeUnit.SECONDS); // Schedule a task to clean up expired locks every 30 seconds
    }

    public SeatLockService() {
        this(Duration.ofMinutes(5));
    }

    public boolean tryLockSeat(User user, Show show, String seatNumber) {
        String key = buildLockKey(show, seatNumber);
        SeatLock newLock = new SeatLock(user, Instant.now().plus(lockDuration));
        SeatLock existingLock = seatLocks.compute(key, (k, currentLock) -> {
            if (currentLock == null || currentLock.getLockedUpto().isBefore(Instant.now())) {
                return newLock;
            }
            return currentLock;
        });
        return existingLock == newLock;
    }

    public SeatLock getSeatLock(Show show, String seatNumber) {
        return seatLocks.get(buildLockKey(show, seatNumber));
    }

    private String buildLockKey(Show show, String seatNumber) {
        return show.getShowId() + "_" + seatNumber;
    }

    public boolean isLockedByUser(Show show, String seatNumber, User user) {
        SeatLock lock = getSeatLock(show, seatNumber);
        return lock != null && lock.getUser().equals(user) && lock.getLockedUpto().isAfter(Instant.now());
    }
}
