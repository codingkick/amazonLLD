package questions.rateLimiter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = RateLimiterFactory.createTokenBucket(5, 2); // capacity of 5 tokens, refills 2 tokens per minute

        for (int i = 0; i < 10; i++) {
            boolean allowed = rateLimiter.handleRequest("user1");
            System.out.println("Request " + (i + 1) + ": " + (allowed ? "Allowed" : "Denied"));
        }
        Thread.sleep(5000); // wait for 1 minute to allow tokens to refill
        for (int i = 0; i < 10; i++) {
            boolean allowed = rateLimiter.handleRequest("user1");
            System.out.println("Request " + (i + 1) + ": " + (allowed ? "Allowed" : "Denied"));
        }
    }
}
