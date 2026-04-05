package RateLimiter_LLD;

public class ApiService {
    IRateLimiter rateLimiter;

    public ApiService(IRateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    public void handleRequests(String request) {
        if(rateLimiter.allowRequests()) {
            System.out.println("Processing request: " + request);
        } else {
            System.out.println("Request " + request + " denied. Rate limit exceeded.");
        }
    }

    public static void main(String[] args) {
        // Create a Fixed Window Rate Limiter with a limit of 5 requests per second
        IRateLimiter fixedWindowRateLimiter = RateLimiterFactory.createFixedWindowRateLimiter(5, 1000);
        ApiService service = new ApiService(fixedWindowRateLimiter);

        System.out.println("Testing Fixed Window Rate Limiter:");
        for(int i =0 ; i< 10 ;i++) {
            if(i == 7) {
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            service.handleRequests("Request " + (i + 1));
        }

         //Create a Token Bucket Rate Limiter with a capacity of 5 tokens and a refill rate of 1 token per second
        IRateLimiter tokenBucketRateLimiter = RateLimiterFactory.createTokenBucketRateLimiter(5, 1);
            ApiService tokenBucketService = new ApiService(tokenBucketRateLimiter);
    
            System.out.println("Testing Token Bucket Rate Limiter:");
            for(int i =0 ; i< 10 ;i++) {
                if(i == 7) {
                    try {
                        Thread.sleep(1000); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                tokenBucketService.handleRequests("Request " + (i + 1));
            }
    }
}
