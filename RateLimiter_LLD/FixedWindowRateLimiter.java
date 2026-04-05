package RateLimiter_LLD;

import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowRateLimiter implements IRateLimiter {

    private final int maxRequests;
    private final long windowSizeInMillis;
    private long windowStart;
    private AtomicInteger requestCount;

    public FixedWindowRateLimiter(int maxRequests, Long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
        this.windowStart = System.currentTimeMillis();
        this.requestCount = new AtomicInteger(0);
    }


    @Override
    public boolean allowRequests() {
        long now = System.currentTimeMillis();

        if(now - windowStart >= windowSizeInMillis) {
            windowStart = now;
            requestCount.set(0);
        }
        
        if(requestCount.incrementAndGet() <= maxRequests) {
            return true;
        } 
            return false;
        
    }
    
    
}
