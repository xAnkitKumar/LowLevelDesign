Design Principles Recap
SRP: Each class has one responsibility.

OCP: Easy to add new limiter strategies.

LSP: All limiters can be used interchangeably via RateLimiter interface.

ISP: Interface is minimal and focused.

DIP: Client depends on abstraction, not concrete class.


======================

What is a Fixed Window Rate Limiter?
It divides time into fixed intervals (windows), e.g., 1 second.

Within each window, you allow a maximum number of requests (say 5).

If the limit is exceeded, further requests are rejected until the next window starts.

=====================

Token Bucket Rate Limiter
How It Works
Imagine a bucket that holds a maximum number of tokens (say 5).

Each incoming request needs a token to proceed.

Tokens are added to the bucket at a fixed rate (e.g., 1 per 200 ms).

If the bucket is empty, requests are rejected until new tokens arrive.

This allows short bursts (up to bucket size) but enforces a steady average rate.