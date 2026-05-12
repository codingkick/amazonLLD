# Rate limiter implementation

Entities:
RateLimiter interface with handleRequest() abstract function.
Implemented TokenBucket algorithm as one of the rate limiting strategy.

Learning:

AtomicInteger -> atomic updates in multi-threaded environment by using function of

tokens.updateAndGet(t->Math.min(capacity, t+refillRate));
tokens.decrementAndGet()
