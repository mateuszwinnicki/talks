package pl.mateuszwinicki.resilience;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ExternalService {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss.S");

    public Response<String> get(final int status, final String response) {
        System.out.println(String.format("[%s] Return standard response", FORMATTER.format(LocalTime.now())));
        return new Response<>(status, response);
    }

    public Response<String> get(final RuntimeException ex) {
        System.out.println(String.format("[%s] Error, exception", FORMATTER.format(LocalTime.now())));
        throw ex;
    }

    public Response<String> getButWait(final int status, final String response, final Duration duration) {
        System.out.println(String.format("[%s] Waiting %s before return", FORMATTER.format(LocalTime.now()), duration));
        try {
            Thread.sleep(duration.toMillis());
        } catch (final InterruptedException e) {
            //
        }
        System.out.println(String.format("[%s] return", FORMATTER.format(LocalTime.now())));
        return new Response<>(status, response);
    }
}
