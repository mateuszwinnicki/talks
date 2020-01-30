package pl.mateuszwinicki.resilience.timelimiter;

import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import pl.mateuszwinicki.resilience.ExternalService;
import pl.mateuszwinicki.resilience.Response;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;

import static pl.mateuszwinicki.resilience.ExternalService.FORMATTER;

public class Main {

    public static void main(final String[] args) {
        final ExternalService service = new ExternalService();

        final TimeLimiterConfig config = TimeLimiterConfig.custom()
            .timeoutDuration(Duration.ofSeconds(3))
            .cancelRunningFuture(true)
            .build();

        final TimeLimiter timeLimiter = TimeLimiter.of(config);

        //fail on timeout
        try {
            final CompletableFuture<Response<String>> responseCompletableFuture = CompletableFuture.supplyAsync(
                () -> service.getButWait(200, "/data/usr/123/logo.png", Duration.ofSeconds(5))
            );
            final Response<String> stringResponse = timeLimiter.executeFutureSupplier(() -> responseCompletableFuture);
            System.out.println(String.format("[%s] returned %s", FORMATTER.format(LocalTime.now()), stringResponse));
        } catch (final Exception e) {
            System.out.println(String.format("[%s] call finished exceptionally %s", FORMATTER.format(LocalTime.now()), e));
        }
        System.out.println();

        //no fail
        try {
            final CompletableFuture<Response<String>> responseCompletableFuture = CompletableFuture.supplyAsync(
                () -> service.getButWait(200, "/data/usr/234/logo.png", Duration.ofSeconds(1))
            );
            final Response<String> stringResponse = timeLimiter.executeFutureSupplier(() -> responseCompletableFuture);
            System.out.println(String.format("[%s] returned %s", FORMATTER.format(LocalTime.now()), stringResponse));
        } catch (final Exception e) {
            System.out.println(String.format("[%s] call finished exceptionally %s", FORMATTER.format(LocalTime.now()), e));
        }
        System.out.println();
    }

}
