package questions.rateLimiter;

public class RateLimiterFactory {
    public static RateLimiter createTokenBucket(int capacity, int refillRate) {
        return new TokenBucket(capacity, refillRate);
    }
}
