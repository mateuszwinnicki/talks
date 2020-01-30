package pl.mateuszwinicki.resilience.ratelimiter;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import pl.mateuszwinicki.resilience.ExternalService;
import pl.mateuszwinicki.resilience.Response;

import java.time.Duration;
import java.util.concurrent.Callable;

public class Main {

    public static void main(final String[] args) throws InterruptedException {
        final ExternalService service = new ExternalService();

        final RateLimiterConfig config = RateLimiterConfig.custom()
            .limitRefreshPeriod(Duration.ofSeconds(10))
            .limitForPeriod(3)
            .timeoutDuration(Duration.ofSeconds(5))
            .build();

        final RateLimiter rateLimiter = RateLimiter.of("RateLimiter", config);


        final Callable<Response<String>> callable = RateLimiter.decorateCallable(
            rateLimiter, () -> service.get(200, "OK")
        );

        for(int i = 0; i < 10; i++){
            new Thread(() -> {
                try {
                    callable.call();
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }


        Thread.sleep(1000 * 10);

    }

}
