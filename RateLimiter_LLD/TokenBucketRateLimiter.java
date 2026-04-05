package RateLimiter_LLD;

public class TokenBucketRateLimiter implements IRateLimiter{ 

    private final int capacity;
    private final int refillRate;
    private double tokens;
    private long lastRefillTimestamp;

    public TokenBucketRateLimiter(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = capacity; // Start with a full bucket
        this.lastRefillTimestamp = System.currentTimeMillis();
    }

    @Override
    public synchronized boolean allowRequests() {
        refill();
        if(tokens>=1) {
            tokens--;
            return true;
         } 
         return false;
        }

        public void refill() {
            long now =System.currentTimeMillis();
            long elapsedTime = now - lastRefillTimestamp;
            double tokensToAdd =(elapsedTime / 1000.0) * refillRate;
            tokens = Math.min(capacity, tokens + tokensToAdd);
            lastRefillTimestamp = now;
        }
    }
    
