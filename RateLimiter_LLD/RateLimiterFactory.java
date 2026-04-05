package RateLimiter_LLD;

public class RateLimiterFactory {
    public static IRateLimiter createFixedWindowRateLimiter( int maxRequests, long windowSizeInMillis) {
        return new FixedWindowRateLimiter(maxRequests, windowSizeInMillis);
    }
    
    public static IRateLimiter createTokenBucketRateLimiter(int capacity, int refillRate) {
        return new TokenBucketRateLimiter(capacity, refillRate);
    }
}
