package RateLimiter_LLD;

public class RateLimiterFactory {
    public static IRateLimiter createFixedWindowRateLimiter( int maxRequests, long windowSizeInMillis) {
        return new FixedWindowRateLimiter(maxRequests, windowSizeInMillis);
    }
    // Future implementations for other rate limiting strategies can be added here eg TokenBucketRateLimiter, SlidingWindowRateLimiter etc.
}
