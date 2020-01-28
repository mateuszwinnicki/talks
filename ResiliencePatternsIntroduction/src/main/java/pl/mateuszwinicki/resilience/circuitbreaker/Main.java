package pl.mateuszwinicki.resilience.circuitbreaker;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import pl.mateuszwinicki.resilience.ExternalService;
import pl.mateuszwinicki.resilience.Response;

import java.time.Duration;
import java.util.concurrent.Callable;

public class Main {

    public static void main(final String[] args) throws Exception {
        final ExternalService service = new ExternalService();
        final CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
            .failureRateThreshold(50)
            .waitDurationInOpenState(Duration.ofSeconds(3))
            .permittedNumberOfCallsInHalfOpenState(2)
            .slidingWindowSize(5)
            .build();

        final CircuitBreaker cb = CircuitBreaker.of("CB", circuitBreakerConfig);

        final Callable<Response<String>> fineCallable = CircuitBreaker.decorateCallable(
            cb, () -> service.get(200, "OK")
        );
        final Callable<Response<String>> badCallable = CircuitBreaker.decorateCallable(
            cb, () -> service.get(new IllegalStateException())
        );

        fineCall(cb, fineCallable);
        fineCall(cb, fineCallable);
        callFailed(cb, badCallable);
        callFailed(cb, badCallable);
        callFailed(cb, badCallable);

        System.out.println("CB is open");
        //circuit opened
        fineCall(cb, fineCallable);
        callFailed(cb, badCallable);

        Thread.sleep(1000 * 3);

        System.out.println("CB is half open");


        System.out.println("Fail again");
        callFailed(cb, badCallable);
        callFailed(cb, badCallable);

        System.out.println("CB is open");
        fineCall(cb, fineCallable);
        fineCall(cb, fineCallable);



    }

    private static void fineCall(final CircuitBreaker cb, final Callable<Response<String>> fineCallable) {
        try {
            System.out.println("failure rate: " + cb.getMetrics().getFailureRate());
            fineCallable.call();
        } catch (final Exception ex) {
            System.out.println(ex);
        }
    }

    private static void callFailed(final CircuitBreaker cb, final Callable<Response<String>> badCallable) {
        try {
            System.out.println("failure rate: " + cb.getMetrics().getFailureRate());
            badCallable.call();
        } catch (final Exception ex) {
            System.out.println(ex);
        }
    }

}
