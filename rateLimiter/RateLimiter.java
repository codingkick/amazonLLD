package questions.rateLimiter;

public interface RateLimiter {
    boolean handleRequest(String userId);
}
