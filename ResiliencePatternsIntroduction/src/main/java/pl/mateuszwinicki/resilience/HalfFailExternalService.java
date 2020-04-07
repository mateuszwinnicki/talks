package pl.mateuszwinicki.resilience;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HalfFailExternalService {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss.S");

    private boolean failNow;

    public HalfFailExternalService(final boolean failNow) {
        this.failNow = failNow;
    }

    public Response<String> get(final int goodStatus, final int wrongStatus, final String response) {
        if(failNow) {
            failNow = false;
            System.out.println(String.format("[%s] Return %d response", FORMATTER.format(LocalTime.now()), wrongStatus));
            return new Response<>(wrongStatus, response);
        }
        failNow = true;
        System.out.println(String.format("[%s] Return %d response", FORMATTER.format(LocalTime.now()), goodStatus));
        return new Response<>(goodStatus, response);
    }

}
