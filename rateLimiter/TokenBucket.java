package questions.rateLimiter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TokenBucket implements RateLimiter {
    //tokens are for the combined use by all the users, so we can use a single variable to keep track of the tokens
    private AtomicInteger tokens;
    private int capacity;
    private int refillRate; // tokens per minute
    TokenBucket(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = new AtomicInteger(capacity); // start with a full bucket
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(()->{
            System.out.println("Refilling tokens...");
            tokens.updateAndGet(t -> Math.min(capacity, t + refillRate));
        }, 2, 2,TimeUnit.SECONDS);
    }
    @Override
    public boolean handleRequest(String userId) {
        if(tokens.decrementAndGet() >= 0) {
            return true; // request allowed
        }
        tokens.incrementAndGet(); // return the token if request is denied
        return false; // request denied
    }
}
