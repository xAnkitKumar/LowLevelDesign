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
        IRateLimiter fixedWindowRateLimiter = RateLimiterFactory.createFixedWindowRateLimiter(5, 1000);
        ApiService service = new ApiService(fixedWindowRateLimiter);

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
    }
}
