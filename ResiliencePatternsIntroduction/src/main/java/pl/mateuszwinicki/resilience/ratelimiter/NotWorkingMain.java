package pl.mateuszwinicki.resilience.ratelimiter;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import pl.mateuszwinicki.resilience.ExternalService;
import pl.mateuszwinicki.resilience.Response;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.Callable;

public class NotWorkingMain {

    public static void main(final String[] args) throws InterruptedException {
        final ExternalService service = new ExternalService();

        final RateLimiterConfig config = RateLimiterConfig.custom()
            .limitRefreshPeriod(Duration.ofSeconds(10))
            .limitForPeriod(3)
            .timeoutDuration(Duration.ofSeconds(11))
            .build();

        final RateLimiter rateLimiter = RateLimiter.of("RateLimiter", config);


        final Callable<Response<String>> callable = RateLimiter.decorateCallable(
            rateLimiter, () -> service.get(200, "OK")
        );

        for(int i = 0; i < 10; i++){
            final int a = i;
            Thread.sleep(new Random(a).nextInt(2000));
            new Thread(() -> {
                try {

                    callable.call();
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }


        Thread.sleep(1000 * 20);
    }

}
