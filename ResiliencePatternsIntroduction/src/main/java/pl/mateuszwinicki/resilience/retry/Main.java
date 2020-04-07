package pl.mateuszwinicki.resilience.retry;

import io.github.resilience4j.core.IntervalFunction;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import pl.mateuszwinicki.resilience.ExternalService;
import pl.mateuszwinicki.resilience.HalfFailExternalService;
import pl.mateuszwinicki.resilience.Response;

import java.time.Duration;

public class Main {

    public static void main(final String[] args) {
        final ExternalService service = new ExternalService();

        final RetryConfig config = RetryConfig.<Response<String>>custom()
            .maxAttempts(3)
            .waitDuration(Duration.ofSeconds(1))
            .intervalFunction(IntervalFunction.ofExponentialBackoff(2000))
            .retryOnResult(r -> r.getStatus() == 500)
            .retryOnException(e -> true)
            .retryExceptions(RuntimeException.class)
            .ignoreExceptions(IllegalArgumentException.class)
            .build();

        final Retry retry = Retry.of("LogoFetch", config);

        System.out.println("First scenario: service always fails (retry on result)");
        final Response<String> response1 = Retry.decorateSupplier(
            retry, () -> service.get(500, "/data/usr/123556/logo.png")
        ).get();

        System.out.println("Response 1:" + response1);
        System.out.println();

        System.out.println("Second scenario: service return value after first call");
        final Response<String> response2 = Retry.decorateSupplier(
            retry, () -> service.get(200, "/data/usr/123556/logo.png")
        ).get();

        System.out.println("Response 2:" + response2);
        System.out.println();

        System.out.println("Third scenario: service always fails (retry on exception)");
        try {
            final Response<String> response3 = Retry.decorateSupplier(
                retry, () -> service.get(new IllegalStateException())
            ).get();
        } catch (final Exception ex) {
            System.out.println("Response 3 ended exceptionally");
        }

        System.out.println("Fourth scenario: first call fails, second fine");

        final HalfFailExternalService halfFailExternalService = new HalfFailExternalService(true);
        final Response<String> response4 = Retry.decorateSupplier(
            retry, () -> halfFailExternalService.get(200, 500, "/data/usr/123556/logo.png")
        ).get();
        System.out.println("Response 4:" + response4);
    }

}
